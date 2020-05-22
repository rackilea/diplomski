public class ContextListener implements ServletContextListener
{
    String secretKey = "";
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext context = sce.getServletContext();
        secretKey = new SaltSecretKey().getSecretKey(); //My custom class
        context.setAttribute("secretKey", secretKey);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        ServletContext context = sce.getServletContext();
        context.removeAttribute("secretKey");
    }

}