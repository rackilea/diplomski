public static void main(String... args) throws Exception
{
    Server server = new Server(8080);

    ServletContextHandler context = new ServletContextHandler();
    context.setContextPath("/");
    context.setWelcomeFiles(new String[] { "index.html" });

    WebSocketUpgradeFilter filter = WebSocketUpgradeFilter.configureContext(context);

    filter.addMapping(new ServletPathSpec("/foo/*"),new SingleWebSocketCreator(FooSocket.class));
    filter.addMapping(new ServletPathSpec("/bar/*"),new SingleWebSocketCreator(BarSocket.class));
    filter.addMapping(new ServletPathSpec("/*.ws"),new SingleWebSocketCreator(WsTypeSocket.class));
    filter.addMapping(new RegexPathSpec("/chat/room/[a-zA-z_]*/public"),new SingleWebSocketCreator(ChatSocket.class));

    // add your own non-websocket servlets
    context.addServlet(HelloServlet.class,"/hello");

    // Lastly, the default servlet for root content (serves up static content)
    // It is important that this is last.
    ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
    holderPwd.setInitParameter("resourceBase","./webapp");
    holderPwd.setInitParameter("dirAllowed","true");
    context.addServlet(holderPwd,"/");

    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
    server.setHandler(handlers);

    server.start();
    server.join();
}