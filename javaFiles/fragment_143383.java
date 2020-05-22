public static void main(String[] args) {

    String userName = "admin";
    String password = "s3cret";
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://192.168.10.10:389/DC=SOFTWAREDEV,DC=LOCAL");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, new String("softwaredev" + "\\" + userName));
    env.put(Context.SECURITY_CREDENTIALS, password);
    String path = "OU=SoftwareV3,OU=SOFTWARE";
    String newUser = "myUser"; // insert user here
    String entryDN = "CN=" + newUser + "," + path;
    Attribute cn = new BasicAttribute("cn", newUser);
    Attribute oc = new BasicAttribute("objectClass");
    oc.add("top");
    oc.add("person");
    oc.add("organizationalPerson");
    oc.add("user");

    DirContext ctx = null;

    try {
        ctx = new InitialDirContext(env);
        Attributes entry = new BasicAttributes();
        entry.put(cn);
        entry.put(oc);
        ctx.createSubcontext(entryDN, entry);
        System.out.println("AddUser: added entry " + entryDN + ".");

    } catch (NamingException e) {
        System.err.println("AddUser: error adding entry." + e);
    }
}