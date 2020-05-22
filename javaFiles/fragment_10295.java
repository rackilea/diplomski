private void sendError() {
    ServletContext servletContext = getServletContext();
    HttpServletResponse response = getThreadLocalResponse();
    try {
          response.setContentType("text/plain");
          response.setStatus(HttpServletResponse.SC_CONFLICT);
          try {
            response.getOutputStream().write("wrong client version".getBytes("UTF-8"));
          } catch (IllegalStateException e) {
            // Handle the (unexpected) case where getWriter() was previously used
            response.getWriter().write("wrong client version");
          }
        } catch (IOException ex) {
          servletContext.log(
              "sendError failed while sending the previous custom failure to the client", ex);
        }
}