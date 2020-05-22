public class LdapTest {

public static void main(String[] args) {

    Properties initialProperties = new Properties();
    initialProperties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    initialProperties.put(Context.PROVIDER_URL, "ldap://192.168.0.179:389");
    initialProperties.put(Context.SECURITY_PRINCIPAL, "cn=Directory Manager");
    initialProperties.put(Context.SECURITY_CREDENTIALS, "dirmanager");
    initialProperties.put(Context.SECURITY_AUTHENTICATION, "simple");

    try {
    InitialDirContext context = new InitialDirContext(initialProperties);
    System.out.println(context);
    }
    catch(Exception e)
    {e.printStackTrace();}
    }
}