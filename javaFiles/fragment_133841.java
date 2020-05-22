JasperPrint print = JasperFillManager.fillReport(jasperReport, param, con);
File outputFile = new File("[Your destination filename goes here]"); 
JRPdfExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE, outputFile);
exporter.setParameter(JRPdfExporterParameter.PDF_VERSION, JRPdfExporterParameter.PDF_VERSION_1_2);
exporter.exportReport();