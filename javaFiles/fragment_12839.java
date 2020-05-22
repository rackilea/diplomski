Attributes attrs = idc.getAttributes("netnix.org", new String[] { "*" });
NamingEnumeration<?> ae = attrs.getAll();

while (ae.hasMore()) {
  Attribute attr = (Attribute)ae.next();
  for (int i = 0; i < attr.size(); i++) {
    Object a = attr.get(i);
    if (a instanceof String) {
      System.out.println(attr.getID() + " " + a);
    }
    else {
      System.out.println(attr.getID() + " NOT ASCII");
    }
  }
}
ae.close();