protected static JasperReport compileReport() throws JRException {

    String sourceName = "/path/to/your/.jrxml";
    String destName = "/path/to/where/you/want/your.jasper";
    JasperCompileManager.compileReportToFile(sourceName, destName);
    return (JasperReport) JRLoader.loadObjectFromFile(destName);

}