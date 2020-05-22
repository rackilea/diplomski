private HttpServletRequest request;

public void run() {

    final RequestContextListener rcl = new RequestContextListener();
    final ServletContext sc = request.getServletContext();
    rcl.requestInitialized(new ServletRequestEvent(sc, request));