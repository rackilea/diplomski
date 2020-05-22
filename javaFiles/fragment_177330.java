// PersistentTokenRememberMeServices.java

protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
    successfulAuthentication) {

    String login = successfulAuthentication.getName();

    log.debug("Creating new persistent login for user {}", login);

    PersistentToken t = new PersistentToken();
    t.setSeries(RandomUtil.generateSeriesData());
    t.setTokenValue(RandomUtil.generateTokenData());
    t.setTokenDate(LocalDate.now());
    t.setIpAddress(request.getRemoteAddr());
    t.setUserAgent(request.getHeader("User-Agent"));

    PersistentToken token = userRepository.findOneByLogin(login).map(u -> {
        t.setUser(u);
        return t;
    }).orElse(null);

    if (token == null) {
        if (successfulAuthentication.getPrincipal() instanceof LdapUserDetails) {
            User ldapUser = new User();
            ldapUser.setLogin(login);
            ldapUser.setPassword(RandomStringUtils.random(60)); // We use LDAP password, but the password need to be set
            ldapUser.setActivated(true);

            CustomLdapUserDetails customLdapUserDetails = (CustomLdapUserDetails) successfulAuthentication.getPrincipal();
            ldapUser.setEmail(customLdapUserDetails.getEmail());
            ldapUser.setFirstName(customLdapUserDetails.getFirstName());
            ldapUser.setLastName(customLdapUserDetails.getLastName());

            Set<Authority> authorities = new HashSet<>();
            authorities.add(this.authorityRepository.findOneByName("ROLE_USER"));
            ldapUser.setAuthorities(authorities);
            ldapUser.setLangKey("fr");

            userRepository.save(ldapUser);
            t.setUser(ldapUser);
            token = t;
        } else {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }
    }
    ...
}