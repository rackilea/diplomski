// get the JRXML template as a stream
InputStream template = JasperReportsApplication.class
    .getResourceAsStream("/sampleReport.xml");
// compile the report from the stream
JasperReport report = JasperCompileManager.compileReport(template);
// fill out the report into a print object, ready for export. 
JasperPrint print = JasperFillManager.fillReport(report, new HashMap<String, String>());
// export it!
File pdf = File.createTempFile("output.", ".pdf");
JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));