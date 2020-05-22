public class TestReport {
    public static void main(String[] args) throws JRException {

        Handler.install(); //Install Joop's protocol handler

         //Compile report and fill, no datasource needed
        JasperReport report = JasperCompileManager.compileReport("htmlComponentBase64.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap<String, Object>());

        //Export to pdf
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("pdf/htmlcomponentbase64.pdf"));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

    }
}