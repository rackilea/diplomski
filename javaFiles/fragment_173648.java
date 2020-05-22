@Bean
public JasperReportsViewResolver getJasperReportsViewResolver() {
  JasperReportsViewResolver resolver = new JasperReportsViewResolver();
  resolver.setPrefix("classpath:/jasperreports/");
  resolver.setSuffix(".jasper");
  resolver.setReportDataKey("datasource");
  resolver.setViewNames("rpt_*");
  resolver.setViewClass(JasperReportsMultiFormatView.class);
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