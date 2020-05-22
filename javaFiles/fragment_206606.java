// setting some response headers
response.setHeader("Expires", "0");
response.setHeader("Cache-Control",
    "must-revalidate, post-check=0, pre-check=0");
response.setHeader("Pragma", "public");
// setting the content type
response.setContentType("application/pdf");
// the contentlength
response.setContentLength(baos.size());
// write ByteArrayOutputStream to the ServletOutputStream
OutputStream os = response.getOutputStream();
baos.writeTo(os);
os.flush();
os.close();