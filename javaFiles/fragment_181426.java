package com.company.foo;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.TagLibConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class EmbedMe {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(port);

        String wardir = "target/sample-webapp-1-SNAPSHOT";

        WebAppContext context = new WebAppContext();
        // This can be your own project's jar file, but the contents should
        // conform to the WAR layout.
        context.setResourceBase(wardir);
        // A WEB-INF/web.xml is required for Servlet 3.0
        context.setDescriptor(wardir + "WEB-INF/web.xml");
        // Initialize the various configurations required to auto-wire up
        // the Servlet 3.0 annotations, descriptors, and fragments
        context.setConfigurations(new Configuration[] {
                            new AnnotationConfiguration(), 
                            new WebXmlConfiguration(),
                            new WebInfConfiguration(), 
                            new TagLibConfiguration(),
                            new PlusConfiguration(), 
                            new MetaInfConfiguration(),
                            new FragmentConfiguration(), 
                            new EnvConfiguration() });

        // Specify the context path that you want this webapp to show up as
        context.setContextPath("/");
        // Tell the classloader to use the "server" classpath over the
        // webapp classpath. (this is so that jars and libs in your
        // server classpath are used, requiring no WEB-INF/lib 
        // directory to exist)
        context.setParentLoaderPriority(true);
        // Add this webapp to the server
        server.setHandler(context);
        // Start the server thread
        server.start();
        // Wait for the server thread to stop (optional)
        server.join();
    }
}