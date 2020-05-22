public class UnitTestWebservices extends AbstractHandler {

    private Server server;

    private Map<Route,String> data = new HashMap<Route,String>();

    public UnitTestWebservices(int port) throws Exception {

        server = new Server(port);
        server.setHandler(this);
        server.start();

    }

    public void handle(String url, final Request rawRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final Route route = Route.valueOf(request.getMethod(), url);

        final String content = data.get(route);

        if(content != null) {
            final ServletOutputStream stream = response.getOutputStream();

            stream.print(content);
            stream.flush();
            stream.close();
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}