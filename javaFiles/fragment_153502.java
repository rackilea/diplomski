import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class SampleLDAPSearch {

  private Attribute getCertFromLdap() {
      String targetDomain = "localhost";
      String port = "10389";

      Hashtable env = new Hashtable();
      env.put(DirContext.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
      SearchControls sc1 = new SearchControls();
      sc1.setSearchScope(SearchControls.OBJECT_SCOPE);
      sc1.setReturningAttributes(new String[] { "namingContexts" });

      try {
          env.put(DirContext.PROVIDER_URL, "ldap://" + targetDomain + ":" + port);

          System.out.println("ldap://" + targetDomain + ":" + port);

          DirContext dc = new InitialDirContext(env);
          NamingEnumeration directoryNE = null;

          System.out.println("Got HERE!");
          directoryNE = dc.search("", "objectclass=*", sc1);

          System.out.println("SC1 :" + sc1);
          while (directoryNE.hasMore()) {
              SearchResult result1 = (SearchResult) directoryNE.next();

              // print DN of entry
              System.out.println("Result.getNameInNamespace: " + result1.getName());
              Attributes attrs = result1.getAttributes();
              Attribute attr = attrs.get("namingContexts");
              System.out.println(attr);

          }
          dc.close();
      } catch (NamingException e) {
          System.out.println("No Results for: " + targetDomain + "\nProblem: " + e.getLocalizedMessage() + "  "
                  + e.getCause());
      }
      return null;

  }

  public static void main(String[] args) {
      SampleLDAPSearch sls = new SampleLDAPSearch();
      sls.getCertFromLdap();
  }
}