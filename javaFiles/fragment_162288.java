@Bean
public JasperReportsPdfView getJasperReports(){
    JasperReportsPdfView view = new JasperReportsPdfView();
    view.setUrl("classpath:jasperReports/test.jrxml");
    view.setReportDataKey("datasource");
    return view;
}