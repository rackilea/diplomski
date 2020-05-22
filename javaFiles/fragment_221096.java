JasperDesign jasperDesign = JRXmlLoader.load(new FileInputStream(reportFile));
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperDesign, parameters, conn);

JRXlsExporter exporter = new JRXlsExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint)); //The JasperPrint, filled report
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport)); //Your ByteArrayOutputStream 

SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
configuration.setOnePagePerSheet(true);
configuration.setDetectCellType(true);
configuration.set //The other properties you like to set
exporter.setConfiguration(configuration);

exporter.exportReport();