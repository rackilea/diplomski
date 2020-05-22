File file = FileName.createExcelWorkbookPosition(request.getParameter("BSNS_DT"));
// ...
response.setContentLength((int) file.length());    

InputStream in = new FileInputStream(file);
OutputStream out = response.getOutputStream();
byte[] buffer = new byte[1024];
int len;
while ((len = in.read(buffer)) != -1) {
    out.write(buffer, 0, len);
}
// if using Apache IO, the above code can be simplified to IOUtils.copy(in, out);
// if using Guava, Files.copy(file, out);

// don't forget to close your streams and flush the response buffer