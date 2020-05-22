@ftr   `com.google.appengine.tools.development.ApiProxyLocalImpl log
SEVERE: javax.servlet.ServletContext log: ConnectionServlet: An IncompatibleRemoteServiceException was thrown while processing this call.
com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException: This application is out of date, please click the refresh button on your browser. ( Blocked attempt to access interface 'com.client.RepositoryInterface', which is not implemented by 'com.server.ConnectionServiceImpl'; this is either misconfiguration or a hack attempt )
at com.google.gwt.user.server.rpc.RPC.decodeRequest(RPC.java:252)
at  com.google.gwt.user.server.rpc.RemoteServiceServlet.processCall(RemoteServiceServlet.java:206)
at com.google.gwt.user.server.rpc.RemoteServiceServlet.processPost(RemoteServiceServlet.java:248)