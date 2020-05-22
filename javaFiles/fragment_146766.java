JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportSource);
JasperReport jasperSubReport = JasperCompileManager.compileReport(subReportSource);

Map<String, Object> parameters = new HashMap()<String, Object>;
parameters.put("subreportParameter", jasperSubReport);

JasperFillManager.fillReportToFile(jasperMasterReport, parameters, outputFileName, connection);