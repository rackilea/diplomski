final Server httpServer = new Server(18080);
httpServer.setHandler(new AbstractHandler() {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                response.getWriter().write("This is the HTTP response");            
    }
});
httpServer.start();