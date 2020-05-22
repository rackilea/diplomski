public static void main(String[] args) throws JRException {
    //Compile report
    JasperReport report = JasperCompileManager.compileReport("myJasperReport.jrxml");
    //Setting up some arbitrary data to test the auto creation of datasource
    List<String> someData = new ArrayList<>();
    someData.add("Test1_1.23:Test2_4.32:Test3_1.08");
    someData.add("Test1_2.12:Test2_5.12:Test3_2.13");
    //Fill report
    JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap<>(),new JRBeanCollectionDataSource(someData));
    //Export to pdf
    JRPdfExporter exporter = new JRPdfExporter();       
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("myJasperReport.pdf"));
    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    exporter.setConfiguration(configuration);
    exporter.exportReport();
}