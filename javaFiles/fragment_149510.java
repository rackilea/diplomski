import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * Retrieves the DN from the search results
 */
class FullName {
  public static void printSearchEnumeration(NamingEnumeration retEnum) {
    try {
      while (retEnum.hasMore()) {
        SearchResult sr = (SearchResult) retEnum.next();
        System.out.println(">>" + sr.getNameInNamespace());
      }
    } 
    catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // Set up the environment for creating the initial context
    Hashtable<String, Object> env = new Hashtable<String, Object>(11);
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

    env.put(Context.PROVIDER_URL, "ldap://localhost:389");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, "uid=administrator,cn=admins,cn=city");
    env.put(Context.SECURITY_CREDENTIALS, "PASS");

    // Perform search in the entire subtree.
    SearchControls ctl = new SearchControls();
    ctl.setSearchScope(SearchControls.SUBTREE_SCOPE);

    try {
      // Create initial context
      DirContext ctx = new InitialDirContext(env);

      NamingEnumeration answer = ctx.search("", null, ctl);

      // Print the answer
      printSearchEnumeration(answer);

      // Close the context when we're done
      ctx.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}