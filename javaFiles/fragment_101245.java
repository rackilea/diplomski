public class MyCasAuthenticationUserDetailsService implements AuthenticationUserDetailsService<Authentication> {

           @Override
            public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
            sAMAccountName = token.getName();

            init();

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (String role : getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role));
            }

            CasUser user = new CasUser(sAMAccountName, NON_EXISTENT_PASSWORD_VALUE, authorities);

            // Sets additional user details
            user = initialiseAdditionalUserDetails(sAMAccountName, user);

            return user;
            }

              /**
             * Retrieves the user roles from LDAP
             * 
             * @return
             */
            private List<String> getRoles() {

            List<String> result = new ArrayList<String>();

            try {
                SearchResult searchResult = searchExecutor.search(connectionFactory, "(sAMAccountname=" + sAMAccountName + ")", "memberOf").getResult();
                LdapEntry entry = searchResult.getEntry();

                if (entry != null) {
                Collection<String> roles = entry.getAttribute().getStringValues();
                StringBuffer rolesCSV = new StringBuffer();

                for (String role : roles) {
                    int start = role.indexOf("=");
                    int end = role.indexOf(",");
                    rolesCSV.append(role.substring(start + 1, end));
                    rolesCSV.append(",");
                }
                String role = rolesCSV.deleteCharAt(rolesCSV.length() - 1).toString();
                String rolesArr[] = role.split(",");
                result = Arrays.asList(rolesArr);
                }

            } catch (LdapException e) {
                LOG.error(e);
            }

            return result;
            }


        /**
             * Initialise additional user details like country, ISO country code, email,
             * etc
             * 
             */
            private CasUser initialiseAdditionalUserDetails(String sAMAccountName, CasUser user) {
            try {
                SearchResult searchResult = searchExecutor.search(connectionFactory, "(sAMAccountname=" + sAMAccountName + ")", "c", "co", "mail",
                    "givenName", "sn", "displayName").getResult();
                LdapEntry entry = searchResult.getEntry();

                if (entry != null) {
                if (entry.getAttribute("givenName") != null) {
                    String firstName = entry.getAttribute("givenName").getStringValue();
                    user.setFirstName(firstName);
                }
                if (entry.getAttribute("sn") != null) {
                    String lastName = entry.getAttribute("sn").getStringValue();
                    user.setLastName(lastName);
                }
                if (entry.getAttribute("displayName") != null) {
                    String fullName = entry.getAttribute("displayName").getStringValue();
                    user.setFullName(fullName);
                }

                if (entry.getAttribute("c") != null) {
                    String isoCountryCode = entry.getAttribute("c").getStringValue();
                    user.setIsoCountryCode(isoCountryCode);
                }
                if (entry.getAttribute("co") != null) {
                    String country = entry.getAttribute("co").getStringValue();
                    user.setCountry(country);
                }
                if (entry.getAttribute("mail") != null) {
                    String email = entry.getAttribute("mail").getStringValue();
                    user.setEmail(email);
                }

                }

            } catch (LdapException e) {
                LOG.error(e);
            }

            return user;
            }
        }