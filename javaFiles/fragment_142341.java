private String formURL(HttpServletRequest req) {
    // get the request check if it contains the customer
    String reqUrl = req.getRequestURI();
    if (log.isInfoEnabled() {
      log.info("Original Url is"+reqUrl);
    }
    if(reqUrl.contains("test")) {
      return reqUrl.replace("test", "abcd");
    }
    return "Someurl";