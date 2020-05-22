public void contextInitialized(ServletContextEvent servletContextEvent) 
    {
          System.out.println("ServletContextListener started"); 
         //start thread here
    }
public void contextDestroyed(ServletContextEvent servletContextEvent) {
     //stop thread here
}