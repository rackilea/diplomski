public void run() {
    while (true) {
        socket = queue.take();
        ServletRequest request = getRequest(socket.getInputStream());
        ServletResponse response = generateResponse(socket.getOutputStream());
        Servlet servletInstance = determineServletInstance(request);
        FilterChain chain = determineFilterChainWithServlet(request, servletInstance);
        chain.doFilter(request,response); // down the line invokes the servlet#service method
        // do some cleanup, close streams, etc.
    }
}