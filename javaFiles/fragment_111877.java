As this is not spring managed bean, we need to manually inject dependencies. (make sure bean names are correct)

@Weblistener
public class SessionListener implements HttpSessionListener {

    private LoginEventRepository loginEventRepo;

    private JdbcHSqlRepository getJdbcHSqlRepository(HttpSessionEvent evt){
      if(loginEventRepo != null) {
         ApplicationContext ctx = WebApplicationContextUtils.
             getWebApplicationContext(evt.getServletContext());

         this.loginEventRepo = (LoginEventRepository) 
                            ctx.getBean("loginEventRepo");
      }
      return this.loginEventRepo;
    }
}