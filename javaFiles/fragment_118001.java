// At the top of the class: setup the imports    
    import java.net.URL;
    import org.eclipse.jetty.server.Handler;
    import org.eclipse.jetty.server.Server;
    import org.eclipse.jetty.server.handler.HandlerList;
    import org.eclipse.jetty.servlet.ServletContextHandler;
    import org.eclipse.jetty.servlet.ServletHolder;
    import org.eclipse.jetty.webapp.WebAppContext;

    ...

    // somewhere in your class ...          

    // Locate the path of the "webroot" folder, containing the images etc ...      
    URL warUrl = this.getClass().getClassLoader().getResource("webroot");
    String warUrlString = warUrl.toExternalForm();

    // Create a webAppContext, pointing the "webroot" folder to the "/files" url. 
    // The files will be available at <server>:<port>/files
    WebAppContext wac = new WebAppContext();
    wac.setResourceBase(warUrlString);
    wac.setContextPath("/files");

    // Setup your servlet ("myServlet"), so it can be accessed in the browser. 
    // The servlet can be used at <server>:<port>/hello
    // Note: for some unknown reason, I was forced to configure the servlet
    // with the root contextpath "/" last !  
    ServletContextHandler sch = new ServletContextHandler(ServletContextHandler.SESSIONS);
    sch.setContextPath("/");
    sch.setResourceBase(warUrlString);
    sch.addServlet(new ServletHolder(myServlet),"/hello");

    // Attach handlers to the server
    HandlerList handlerList = new HandlerList();
    handlerList.setHandlers(new Handler[]{wac, sch});
    myServer.setHandler(handlerList);