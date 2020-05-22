Attributes attrs = dirContext.getAttributes("paypal.com", new String[] { "TXT" });
Attribute txt = attrs.get("TXT");
NamingEnumeration e = txt.getAll();
while (e.hasMore()) {
     System.out.println(e.next());
}