package jetty.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class ConnectorSpecificContexts
{
    public static void main(String[] args)
    {
        Server server = new Server();

        ServerConnector connectorA = new ServerConnector(server);
        connectorA.setPort(8080);
        connectorA.setName("connA"); // connector name A
        ServerConnector connectorB = new ServerConnector(server);
        connectorB.setPort(9090);
        connectorB.setName("connB"); // connector name B

        server.addConnector(connectorA);
        server.addConnector(connectorB);

        // Basic handler collection
        HandlerCollection contexts = new HandlerCollection();
        server.setHandler(contexts);

        // WebApp A
        WebAppContext appA = new WebAppContext();
        appA.setContextPath("/a");
        appA.setWar("./webapps/webapp-a.war");
        appA.setVirtualHosts(new String[]{"@connA"}); // connector name A
        contexts.addHandler(appA);

        // WebApp B
        WebAppContext appB = new WebAppContext();
        appB.setContextPath("/b");
        appB.setWar("./webapps/webapp-b.war");
        appB.setVirtualHosts(new String[]{"@connB"}); // connector name B
        contexts.addHandler(appB);

        try
        {
            server.start(); // start server thread
            server.join(); // wait for server thread to end
        }
        catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }
}