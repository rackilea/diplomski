public static void main(String[] args) throws Exception {
Uploader uploader = new Uploader();    
String filePath = "file/path";
File file = new File(filePath);
byte[] bytes = Utilities.fileToByteArray(file); // convert file to bytes
String mimeType = Utilities.getMimeType(bytes); // bytes from above used with tika
String url = uploader.getLocation("bucket", file.getName(), mimeType);
Response r = uploader.doUpload(url, new FileInputStream(file), mimeType);
System.out.println("Response : " + r.getStatus());
System.out.println(r.getHeaders());
}