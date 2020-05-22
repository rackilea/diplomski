public static byte[] exportToHtmlWithConn(String urlReport, Connection conn) throws JRException {

    Map<String, Object> parameters = new HashMap<>();

    parameters = returnLogoPutAsParam();

    JasperReport report = JasperCompileManager.compileReport(JasperUtilities.class.getResourceAsStream(urlReport));
    jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    HtmlExporter exporter = new HtmlExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

    SimpleHtmlExporterOutput htmlExporterOutput = new SimpleHtmlExporterOutput(baos);
    htmlExporterOutput.setImageHandler(new FileHtmlResourceHandler(new File("html_images"), "/web/resources/images/logo.png"));

    exporter.setExporterOutput(htmlExporterOutput);
    exporter.exportReport();

    return baos.toByteArray();
}