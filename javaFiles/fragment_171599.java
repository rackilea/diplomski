protected SerializationPolicy doGetSerializationPolicy(
      HttpServletRequest request, String moduleBaseURL, String strongName) {
    // The request can tell you the path of the web app relative to the
    // container root.
    String contextPath = request.getContextPath();
    String modulePath = null;
    if (moduleBaseURL != null) {
      try {
        modulePath = new URL(moduleBaseURL).getPath();
      } catch (MalformedURLException ex) {
        // log the information, we will default
        log("Malformed moduleBaseURL: " + moduleBaseURL, ex);
      }
    }
...