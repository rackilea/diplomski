Map<String, Object> params = new HashMap<>();
params.put(JsonQLQueryExecuterFactory.JSON_INPUT_STREAM, request);
JasperReport jasperReport = (JasperReport) 
JRLoader.loadObject(jasperTemplateStream);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
JasperExportManager.exportReportToPdfStream(jasperPrint, response);