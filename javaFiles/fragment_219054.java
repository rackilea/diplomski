public class OneServletContext{
   public static void main(String[] args) throws Exception{
     Server server = new Server(8080);

     ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
     context.setContextPath("/");
     server.setHandler(context);

     context.addServlet(new ServletHolder(new HelloServlet()),"/*");
     context.addServlet(new ServletHolder(new HelloServlet("Buongiorno Mondo")),"/it/*");
     context.addServlet(new ServletHolder(new HelloServlet("Bonjour le Monde")),"/fr/*");

     server.start();
     server.join();
}