JRXlsxExporter exporter = new JRXlsxExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
xporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
configuration.setWhitePageBackground(true);
configuration.setDetectCellType(true);
\\... set all your configuration like above
exporter.setConfiguration(configuration);
exporter.exportReport();