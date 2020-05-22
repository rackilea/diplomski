DirContext ctx = new InitialDirContext(LDAPDetails());
String[] attrIDs = { "sAMAccountName", "cn", "title", "mailnickname", "mail", "manager", "department", "telephoneNumber" };
SearchControls ctls = new SearchControls();
ctls.setReturningAttributes(attrIDs);
ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
String filter = "(CN=285263)";
NamingEnumeration<SearchResult> answer = ctx.search("OU=users,DC=cts,DC=com", filter, ctls);

while (answer.hasMore()) {
    SearchResult sr = (SearchResult) retEnum.next();
    Attribute mailAttribute = sr.getAttributes().get("mail");
    System.out.println("Team Member's eMail: " + mailAttribute.get()); // Here I am able to get the person's email.
    Attribute managerAttribute = sr.getAttributes().get("manager"); // this is just getting the manager's CN value. Not the email ID.

    // now lookup the manger
    NamingEnumeration<SearchResult> managerAnswer = ctx.search(managerAttribute.get(), "", ctls);
    while (answer.hasMore()) {
        SearchResult managerSr = (SearchResult) retEnum.next();
        Attribute mailAttribute = sr.getAttributes().get("mail");
        System.out.println("Managers eMail: " + mailAttribute.get()); 
    }
}