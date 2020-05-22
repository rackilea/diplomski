try {
    File sourceFile = new File(fullPath);               
    BufferedImage bufferedimage = ImageIO.read(sourceFile);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(bufferedimage, "jpg", os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());
    FileOutputStream fileOutputStream = new FileOutputStream(
    sourceFile);

    int bufferSize;
    byte[] bufffer = new byte[512];

    while ((bufferSize = is.read(bufffer)) > 0) {
        fileOutputStream.write(bufffer, 0, bufferSize);
    }
    is.close();
    fileOutputStream.close();             

    //scaleImage(bufferedimage, 220, 220);  

} catch(Exception e) {
    e.printStackTrace();
}