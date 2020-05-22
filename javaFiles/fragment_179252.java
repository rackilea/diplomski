jasperDesign = JRXmlLoader.load(rootpath + "/WEB-INF/templates/Report.jrxml");
jasperDesignSR = JRXmlLoader.load(rootpath + "/WEB-INF/templates/SubReport.jrxml");


JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
JasperReport jasperReportSR = JasperCompileManager.compileReport(jasperDesignSR);

parameters.put("SubReportParam", jasperReportSR);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);