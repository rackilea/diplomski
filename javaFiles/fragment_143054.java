private FilterConfig config;
  public void init(FilterConfig filterConfig) throws ServletException {
    config = filterConfig;
  }

  public void doFilter(ServletRequest servletRequest,
      ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    File file = new File(config.getServletContext().getRealPath(req.getServletPath()));
    if (file.canRead()) {
      // NOTE: you have to set the most appropriate type per file
      resp.setContentType("text/html");

      // This depends on apache commons-io
      IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
    } else {
      filterChain.doFilter(req, resp);
    }
  }