public class OneWebAppUnassembled
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setDescriptor(webapp+"/WEB-INF/web.xml");
        context.setResourceBase("../test-jetty-webapp/src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }
}