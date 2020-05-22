String realPath = getServletContext().getRealPath("/");

  File file = new File(realPath+"/reports/saida/output/");
  file.mkdirs();

  JasperExportManager.exportReportToPdfFile(print, file.getAbsolutePath +"reportName.pdf");