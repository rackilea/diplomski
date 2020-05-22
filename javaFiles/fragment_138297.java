Part filePart = request.getPart("file");
String fileName = String.valueOf("fileName");
File file = new File("/the/path/" + fileName);
OutStream outFile = new FileOutputStream(file);
InputStream filecontent = filePart.getInputStream();

int read = 0;
byte[] bytes = new byte[1024];
while ((read = filecontent.read(bytes)) != -1) {
    outFile.write(bytes, 0, read);
}