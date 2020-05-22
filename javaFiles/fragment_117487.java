public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    empsuite.model.UserData domainUser = userloginDAO.getUsername(username);

    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    return new CustomUser(
            domainUser.getUsername(),
            domainUser.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(1),
            domainUser.getId());

}