SocketConnector socketConnector = new SocketConnector();
socketConnector.setPort(7000); // Change to port you want
Server server.setConnectors(new Connector[] { socketConnector });

WebAppContext webapp = new WebAppContext();

webapp.setContextPath("/"); // For root
webapp.setWar("/"); // Appropriate file system path.

// Now you can use the various webapp.addFilter() methods
webapp.addFilter(MyFilter.class, "/test", 1); // Will serve request to /test.
// There are 3 different addFilter() variants.

// Bonus ... request logs.
RequestLogHandler logHandler = new RequestLogHandler();
NCSARequestLog requestLog = new NCSARequestLog("/tmp/jetty-yyyy_mm_dd.request.log");
requestLog.setRetainDays(90);
requestLog.setAppend(true);
requestLog.setExtended(false);
requestLog.setLogTimeZone("GMT");
logHandler.setRequestLog(requestLog);

logHandler.setHandler(webapp);

HandlerList handlerList = new HandlerList();
handlerList.addHandler(logHandler);

server.setHandler(handlerList);

server.start();