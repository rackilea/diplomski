@Override
public void onStartup(ServletContext servletContext) throws ServletException {

      FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8", true, true));
      filterRegistration.addMappingForUrlPatterns(null, false, "/*");

      filterRegistration = servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter() );
      filterRegistration.addMappingForUrlPatterns(null, false, "/*");

    super.onStartup(servletContext);
}