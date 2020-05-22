ByteArrayOutputStream baos = new ByteArrayOutputStream();

JRHtmlExporter exporter = new JRHtmlExporter();

exporter.setExporterInput(new SimpleExporterInput(yourJasperPrint));
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos)); 

exporter.exportReport();