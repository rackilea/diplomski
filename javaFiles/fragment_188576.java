authBuilder
            .ldapAuthentication()
            .userSearchFilter("(uid={0})")
            .userSearchBase("")
            .contextSource()
                .url("ldap://ldap.forumsys.com:389/dc=example,dc=com")
           .managerDn("cn=read-only-admin,dc=example,dc=com") 
                .managerPassword("password");