public class AuthManager extends HttpServlet {
protected SaltStyle saltStyle = SaltStyle.COLUMN;
// set remaining fields...
   public void init() throws ServletException { 
          Collection<Realm> realms=((RealmSecurityManager) securityManager).getRealms();    
          CustomJdbcRealm jdbcRealm=(CustomJdbcRealm)realms.toArray()[0];
          jdbcRealm.setSaltStyle(saltStyle);
   }