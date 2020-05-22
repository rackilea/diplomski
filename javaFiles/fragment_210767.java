public void generateFleetReportXlsx(List listOfDailyBean) throws JRException, IOException {
    /*
     Convert List to JRBeanCollectionDataSource 
     */
    JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listOfDailyBean);

    /* 
        Map to hold Jasper Report parameters
    */

    Map<String,Object> parameters = new HashMap<String, Object>();
    parameters.put("ItemDataSource", beanCollectionDataSource);

    String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/sadaqatReport.jasper");
    JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters, beanCollectionDataSource);
    HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.xlsx");
    ServletOutputStream outputStream = httpServletResponse.getOutputStream();
    net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outputStream);
    exporter.exportReport();
    outputStream.flush();
    outputStream.close();
    FacesContext.getCurrentInstance().responseComplete();
}