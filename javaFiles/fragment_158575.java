String[] attrs = {"dn","cn","member"};
 SearchControls controls = new SearchControls();
 controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
 controls.setReturningAttributes(attrs);
 NamingEnumeration<SearchResult> results = lContext.search(ou, "(&(objectClass=group))", controls);
 while (results.hasMore()){
  SearchResult result = results.next();
  System.out.println(result.getNameInNamespace());
  Attributes attributes = result.getAttributes();
  System.out.println("DN "+result.getNameInNamespace());
  System.out.println("CN "+attributes.get("cn"));
  System.out.println("MEMBER "+attributes.get("member"));
  System.out.println("**********************");
 }