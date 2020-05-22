protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String browserType = request.getHeader("User-Agent"); // This is the line you're after

    // This will just output the user agent to the browser
    response.getOutputStream().write(browserType.getBytes());
    response.getOutputStream().close();
}