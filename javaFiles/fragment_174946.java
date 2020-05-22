File initialFile = new File(imagePath);

byte[] bytes = FileUtils.readFileToByteArray(initialFile);
final String base64 = android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT);

Thread uploadFileThread = new Thread(new Runnable() {
    @Override
    public void run() {
        FileToUpload fileToUpload = new FileToUpload();
        fileToUpload.setFile(base64);
        String[] result = ServiceConnector.UploadUserProfilePicture(fileToUpload);
    }
});