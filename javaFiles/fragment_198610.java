LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl("ldap://192.168.99.101:389/");
        contextSource.setUserDn("uid=admin,dc=abc,dc=com");
        contextSource.setPassword(********);
        contextSource.setPooled(false);
        contextSource.afterPropertiesSet();

        LdapTemplate template = new LdapTemplate(contextSource);
        LdifParser parser = new LdifParser(new ClassPathResource("schema.ldif"));
        parser.open();
        while (parser.hasMoreRecords()) {
            LdapAttributes record = parser.getRecord();
            LdapName dn = record.getName();
            template.bind(dn, null, record);
        }