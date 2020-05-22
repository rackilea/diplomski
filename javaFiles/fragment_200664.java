String[] attrIDs = { Constants.UNIQUEMEMBER };
            Attributes answer = iniDirContext.getAttributes("cn=project,dn=aibl,dc=net", attrIDs);

            NamingEnumeration namingEnumeration = answer.getAll();
            Attribute attr = (Attribute) namingEnumeration.next();

            for (NamingEnumeration namingEnumeration1 = attr.getAll(); namingEnumeration1
                    .hasMore();) {

                String str = namingEnumeration1.next().toString();}