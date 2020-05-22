LDAPConnection conn = new LDAPConnection();
conn.connect("blah.blah.address", 389);

String[] attrIDs = {"uniqueMember"};
LDAPSearchResults search = conn.search("dc=foo,dc=bar",
                                       LDAPConnection.SCOPE_ONE,
                                       "cn=testgroup", attrIDs, false);

while(search.hasMore()) {
    LDAPEntry entry = search.next();
    for (String string : entry.getAttribute("uniqueMember").getStringValueArray()) {
        System.out.println(string);
    }
}