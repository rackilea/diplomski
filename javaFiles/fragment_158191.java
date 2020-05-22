public class MyAppServletContextListener 
               implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }


            //Run this before web application is started
        @Override
        public void contextInitialized(ServletContextEvent arg0) {
            System.out.println("ServletContextListener started");   
AbstractApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationScheduler.class);
        }
    }