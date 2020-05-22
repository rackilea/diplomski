String defaultPDFFont = "Arial";

JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
JRProperties.setProperty("net.sf.jasperreports.default.font.name", defaultPDFFont);

JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);

JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);