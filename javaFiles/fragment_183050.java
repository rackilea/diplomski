byte[] uploadedImg = null;
try {
    File f1 = new File(photoUploadPath);
    double fileLen = f1.length();
    uploadedImg = new byte[(int) fileLen];
    FileInputStream inputStream = new FileInputStream(photoUploadPath);
    int nRead = 0;
    while ((nRead = inputStream.read(uploadedImg)) != -1) {
    System.out.println("!!!!!!!!!!!!!!!!!" + new String(uploadedImg));
    }
    inputStream.close();

} catch (Exception e2) {
    // TODO: handle exception
}

BufferedInputStream inputStreamReader = new BufferedInputStream(new ByteArrayInputStream(uploadedImg));
ImageData imageData = new ImageData(inputStreamReader);
Image image = new Image(Display.getCurrent(), imageData);
photoLabel.setImage(image);