JRCsvExporter csvExporter = new JRCsvExporter();
//jasperPrints is Collection, but we need a List
csvExporter.setExporterInput(SimpleExporterInput.getInstance(new ArrayList(jasperPrints)));
csvExporter.setExporterOutput(new SimpleWriterExporterOutput(baos));
SimpleCsvExporterConfiguration exporterConfiguration = new SimpleCsvExporterConfiguration();
//nothing to set here, but you could do things like exporterConfiguration.setFieldDelimiter
csvExporter.setConfiguration(exporterConfiguration);
csvExporter.exportReport();