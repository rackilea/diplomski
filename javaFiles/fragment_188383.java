System.out.println(" --> Exporting to PDF");
JRPdfExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, filledReport);
exporter.setParameter(JRExporterParameter.START_PAGE_INDEX, 0);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "your.pdf");
exporter.exportReport();

System.out.println(" --> Exporting to Excel");
JRXlsxExporter excel = new JRXlsxExporter();
excel.setParameter(JRExporterParameter.JASPER_PRINT, filledReport);
excel.setParameter(JRExporterParameter.START_PAGE_INDEX, 0);
excel.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "your.xlsx");
excel.exportReport();

System.out.println(" --> Exporting to HTML");
JRHtmlExporter html = new JRHtmlExporter();
html.setParameter(JRExporterParameter.JASPER_PRINT, filledReport);
html.setParameter(JRExporterParameter.START_PAGE_INDEX, 0);
html.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "your.html");
html.exportReport();