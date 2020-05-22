Map<String, Object> params = new HashMap<>();
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);

JRXlsxExporter exporter = new JRXlsxExporter();

exporter.setConfiguration(new SimpleXlsxReportConfiguration() {

    @Override
    public String[] getSheetNames() {
        return new String[]{"MyName"};
    }
});
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