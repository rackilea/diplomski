public String captureToBase64() {

    Rectangle screenSize = new 
    Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    BufferedImage screenCapture = null;
    String base64Encoded = "";

    try {

        screenCapture = new Robot().createScreenCapture(screenSize);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenCapture, "jpg", baos);
        baos.flush();
        byte[] encodeBase64 = Base64.encodeBase64(baos.toByteArray());
        base64Encoded = new String(encodeBase64);
        baos.close();

    } catch (AWTException e) {
        e.getMessage();
    }

    return base64Encoded;
}