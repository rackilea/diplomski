public void report(HttpServletResponse response) throws Exception {
    response.setContentType("text/html");
    List data = userReportService.report();
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
    Map parameters = new HashMap();
    parameters.put("test", data.get(0));
    parameters.put("DS1", dataSource);
    InputStream inputStream = this.getClass().getResourceAsStream("/reports/users_report.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
    HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
    exporter.exportReport();
}