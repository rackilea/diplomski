public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException
  {

HttpServletRequest hsr = (HttpServletRequest) request;


String incomingUrl=hsr.getRequestURI(); // fetch URL
String method =hsr.getMethod(); // fetch GET/POST method
logger.debug ("The caller was " + incomingUrl + method); // Send the output to any logger which you have defined
chain.doFilter(request, response);
}