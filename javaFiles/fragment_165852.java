byte[] rawFile = myService.getDocument(param1, param2);

response.setContentType("application/pdf");
response.setHeader("Content-Disposition", "attachment;filename=myfile-1.pdf");
OutputStream out = response.getOutputStream();
out.write(rawFile);
// no need to close or flush, that happens automatically when you return