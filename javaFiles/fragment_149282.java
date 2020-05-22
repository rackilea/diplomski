@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException,
    IOException {

    String clientURL = request.getHeader("Origin");
    response.addHeader(
           "Access-Control-Allow-Origin",
           isInWhileList(clientURL) ? clientUrl : "https://default.ourCompany.com";
    ...