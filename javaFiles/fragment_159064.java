public SearchServlet extends HttpServlet {

    @Autowired
    private SearchManager searchManager;

    public void init(ServletConfig config) {
      super.init(config);
      SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
        config.getServletContext());
    }
  }