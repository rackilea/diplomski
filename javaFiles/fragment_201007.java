//zip password
String pass="abc";
try {
    ZipFile zipFile = new ZipFile("dir/xyz.zip");
      if (zipFile.isEncrypted()) {
         zipFile.setPassword(pass);
    }
//extract somewhere in directory
zipFile.extractAll("dir/abc");
} 
 catch (ZipException e) {
 e.printStackTrace();
}