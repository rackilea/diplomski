// build dynamicreport instance
DynamicReportBuilder dynamicReportBuilder = new DynamicReportBuilder();

dynamicReportBuilder.setHeaderHeight(50); //sets the column header height
dynamicReportBuilder.setDetailHeight(50); //sets the detail band rows height

DynamicReport dynamicReport = dynamicReportBuilder.build();

// build jasperprint..
JasperPrint jasperPrint = DynamicJasperHelper.generateJasperPrint(
    dynamicReport, new ClassicLayoutManager(), dataSource, new HashMap<String, Object>());

// export as html
JRExporter exporter = new JRHtmlExporter();

// tell jasper not to use images for aligning
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);

exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, targetFile);

exporter.exportReport();