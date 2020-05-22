import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.Attributes;
import javax.naming.directory.Attribute;
import javax.naming.NamingException;

public class App {

    /* Ugly HardCoded stuff */
    public static String ldapUri = "ldap://localhost:2389";
    public static String admindn = "cn=Directory Manager";
    public static String admincred = "password";
    public static String usersContainer = "ou=users,dc=example,dc=com";

    public static void main(String args[]){

    if (args.length != 2) {
        System.out.println("Usage: App userName password");
        return;
    }
    String username = args[0];
    String password = args[1];

    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, ldapUri);
            env.put( Context.SECURITY_PRINCIPAL, admindn );
            env.put( Context.SECURITY_CREDENTIALS, admincred );
    try {
            DirContext ctx = new InitialDirContext(env);

        Attributes attrs = new BasicAttributes(true);

        Attribute objclass = new BasicAttribute("objectclass");
        objclass.add("top");
        objclass.add("inetorgperson");

        Attribute surname = new BasicAttribute("sn");
        surname.add(username);

        Attribute pwd = new BasicAttribute("userpassword");
        pwd.add(password);

        attrs.put(objclass);
        attrs.put(surname);
        attrs.put(pwd);

        ctx.createSubcontext("cn="+username+","+usersContainer, attrs);
        ctx.close();


    } catch (NamingException e) {
        e.printStackTrace();
    }


    }
 }