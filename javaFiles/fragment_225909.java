public static Mat screenShot() throws AWTException, IOException {

    Robot r = new Robot();      
    Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
    BufferedImage Image = r.createScreenCapture(capture);       
    Mat mat = BufferedImage2Mat(Image);

    return mat;

}

public static Mat BufferedImage2Mat(BufferedImage image) throws IOException {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(image, "jpg", byteArrayOutputStream);
    byteArrayOutputStream.flush();
    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);

}