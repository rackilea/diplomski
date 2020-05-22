Map<String, Object> params = new HashMap<>();
params.put("stringParam", "ZZZ");
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);

JRXlsxExporter exporter = new JRXlsxExporter();

exporter.setConfiguration(new SimpleXlsxReportConfiguration());
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
SimpleOutputStreamExporterOutput exporterOutput = null;
try (OutputStream outputStream = new FileOutputStream(file)) {
    exporterOutput = new SimpleOutputStreamExporterOutput(outputStream);
    exporter.setExporterOutput(exporterOutput);
    exporter.exportReport();
} finally {
    if (exporterOutput != null) {
        exporterOutput.close();
    }
}