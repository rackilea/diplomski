package net.kingsbery;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class Start {

    public static void main(String[] args) throws Exception {
            Server server = new Server();
            SocketConnector connector = new SocketConnector();

            // Set some timeout options to make debugging easier.                                                                                                                                
            connector.setMaxIdleTime(1000 * 60 * 60);
            connector.setSoLingerTime(-1);
            connector.setPort(10080);
            server.setConnectors(new Connector[] { connector });

            WebAppContext bb = new WebAppContext();
            bb.setServer(server);
            bb.setContextPath("/");
            bb.setWar("src/main/secret-webapp");

            server.addHandler(bb);

            Server server2 = new Server();
            SocketConnector connector2 = new SocketConnector();

            // Set some timeout options to make debugging easier.                                                                                                                                
            connector2.setMaxIdleTime(1000 * 60 * 60);
            connector2.setSoLingerTime(-1);
            connector2.setPort(20000);
            server2.setConnectors(new Connector[] { connector });

            WebAppContext bb2 = new WebAppContext();
            bb2.setServer(server);
            bb2.setContextPath("/");
            bb2.setWar("src/main/webapp");



            server.addHandler(bb);
            server2.addHandler(bb2);

            try {
                    server.start();
                    server2.start();
            } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(100);
            }
    }
}