@Bean @Qualifier("helloWorldReport2")
public JasperReportsPdfView getHelloWorldReport() {
  JasperReportsPdfView v = new JasperReportsPdfView();
  v.setUrl("classpath:jasperreports/HelloWorld2.jasper");
  v.setReportDataKey("datasource");
  return v;
}