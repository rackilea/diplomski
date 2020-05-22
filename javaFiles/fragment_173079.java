//Get the JasperPrint object (exact code to achieve this intentional left out since command depends on application)
JasperPrint jasperPrint = JasperFillManager.fillReport(...); 

//Export to pdf into a memory stream
JRPdfExporter exporter = new JRPdfExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(memoryStream));
SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
exporter.setConfiguration(configuration);
exporter.exportReport();

//Use stamper to set viewer prederence 
PdfReader pdfReader = new PdfReader(new ByteArrayInputStream(memoryStream.toByteArray()));
PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("my.pdf"));          
pdfStamper.getWriter().setViewerPreferences(PdfWriter.PageModeUseOutlines);
pdfStamper.close();
pdfReader.close();