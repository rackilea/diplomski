MockHttpServletRequest servletRequest = new MockHttpServletRequest(
          application, servletSession, context);      MockHttpServletResponse servletResponse = new MockHttpServletResponse(
          servletRequest);

  //initialize request and response       servletRequest.initialize();
  servletResponse.initialize();

  WebRequest webRequest = new WebRequest(servletRequest);

  BufferedWebResponse webResponse = new