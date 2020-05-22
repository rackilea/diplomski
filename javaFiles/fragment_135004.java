JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), jasperReports); 
long start = System.currentTimeMillis(); 

OutputStream output = new FileOutputStream(new File("c:/output/JasperReport.pdf")); 
JasperExportManager.exportReportToPdfStream(print, output); 

// coding For Excel: 


JRXlsExporter exporterXLS = new JRXlsExporter(); 
exporterXLS.setParameter(JRXlsExporterParameter.JA SPER_PRINT, print); 
exporterXLS.setParameter(JRXlsExporterParameter.OU TPUT_STREAM, output); 
exporterXLS.setParameter(JRXlsExporterParameter.IS _ONE_PAGE_PER_SHEET, Boolean.TRUE); 
exporterXLS.setParameter(JRXlsExporterParameter.IS _AUTO_DETECT_CELL_TYPE, Boolean.TRUE); 
exporterXLS.setParameter(JRXlsExporterParameter.IS _WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
exporterXLS.setParameter(JRXlsExporterParameter.IS _REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
exporterXLS.exportReport();