byte[] byteArray = //your byte array

response.setContentType("YOUR CONTENT TYPE HERE");
response.setHeader("Content-Disposition", "filename=\"THE FILE NAME\"");
response.setContentLength(byteArray.length);
OutputStream os = response.getOutputStream();

try {
   os.write(byteArray , 0, byteArray.length);
} catch (Exception excp) {
   //handle error
} finally {
    os.close();
}