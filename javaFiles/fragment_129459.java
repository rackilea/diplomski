@Autowired
LogoutFilter logoutFilter;


private void doLogout() {
    MockHttpServletRequest request = new MockHttpServletRequest(
          "GET",
          "http://myApp" + this.logoutFilter.getFilterProcessingUrl());        

    this.logoutFilter.doFilter(request, new MockHttpServletResponse(),
                               new MockFilterChain());
}