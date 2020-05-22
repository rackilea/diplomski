byte[] buffer = new byte[1024];

try {

FileInputStream fileToZip = new FileInputStream("filename.txt");
FileOutputStream fileOutputStream = new FileOutputStream("filename.zip");
ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

ZipEntry zipEntry= new ZipEntry("filename.txt");
zipOutputStream.putNextEntry(zipEntry);

int len;
while ((len = fileToZip.read(buffer)) > 0) {
    zipOutputStream.write(buffer, 0, len);
}

fileToZip.close();
zipOutputStream.closeEntry();
zipOutputStream.close();

} catch(IOException e) {
   e.printStackTrace();
}