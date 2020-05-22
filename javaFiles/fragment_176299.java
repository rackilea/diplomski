@Override
protected DirContextOperations searchForUser(DirContext ctx, String username) throws NamingException {
    SearchControls searchCtls = new SearchControls();
    searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

    //this doesn't work, and I'm not sure exactly what the value of the parameter {0} is
    //String searchFilter = "(&(objectClass=user)(userPrincipalName={0}))";
    String searchFilter = "(&(objectClass=user)(userPrincipalName=" + username + "@domain.tld))";

    final String bindPrincipal = createBindPrincipal(username);
    String searchRoot = rootDn != null ? rootDn : searchRootFromPrincipal(bindPrincipal);

    return SpringSecurityLdapTemplate.searchForSingleEntryInternal(ctx, searchCtls, searchRoot, searchFilter, new Object[]{bindPrincipal});