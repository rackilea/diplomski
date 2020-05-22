public static void toEXCEL(JRBeanCollectionDataSource beanCollectionDataSource, String reportPath, Map<String, Object> params, String reportName) throws Exception{
    JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, beanCollectionDataSource);
    HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + reportName + ".xlsx");
    ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
    JRXlsExporter xlsExporter = new JRXlsExporter();
    xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(servletOutputStream));
    xlsExporter.exportReport();

    FacesContext.getCurrentInstance().responseComplete();
}