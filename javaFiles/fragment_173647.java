@Bean
public ResourceBundleViewResolver getResourceBundleViewResolver() {
  ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
  resolver.setBasename("jasperreport-views");
  resolver.setOrder(0);
  return resolver;
}

@Bean
public InternalResourceViewResolver getInternalResourceViewResolver() {
  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
  resolver.setPrefix("/WEB-INF/views/");
  resolver.setSuffix(".jsp");
  resolver.setOrder(1);
  return resolver;
}