String url = "ldap://directory.cornell.edu/o=Cornell%20University,c=US";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        DirContext context = new InitialDirContext(env);

        SearchControls ctrl = new SearchControls();
        ctrl.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration enumeration = context.search("", query, ctrl);
        while (enumeration.hasMore()) {
            SearchResult result = (SearchResult) enumeration.next();
            Attributes attribs = result.getAttributes();
            NamingEnumeration values = ((BasicAttribute) attribs.get(attribute)).getAll();
            while (values.hasMore()) {
              if (output.length() > 0) {
                output.append("|");
              }
              output.append(values.next().toString());
            }
        }