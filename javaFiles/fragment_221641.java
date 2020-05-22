OutputStream outputStream = response.getOutputStream();
response.setContentType("application/pdf");
response.setHeader("Content-disposition","attachment;filename="+filename);
report.toPdf(OutputStream);
OutputStream.flush();
OutputStream.close();