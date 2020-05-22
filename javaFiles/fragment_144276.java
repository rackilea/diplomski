String fileName = "excel.xls";
HttpServletResponse response = getResponse(); // get ServletResponse
response.setContentType("application/vnd.ms-excel"); // Set up mime type
response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
OutputStream out = response.getOutputStream()
wb.write(out);
out.flush();