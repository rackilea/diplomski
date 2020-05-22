public static void unzip(){
    String source = "some/compressed/file.zip";
    String destination = "some/destination/folder";
    String password = "password";

    try {
         ZipFile zipFile = new ZipFile(source);
         if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
         }
         zipFile.extractAll(destination);
    } catch (ZipException e) {
        e.printStackTrace();
    }
}