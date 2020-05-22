public static InputStream returnLogoByte() {
    InputStream is = null;
    try {
        byte[] imageByteArray;
        BufferedImage img = ImageIO.read(JasperUtilities.class.getResourceAsStream("/reports/logo.png"));
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        ImageIO.write(img, "bmp", bas);
        imageByteArray = bas.toByteArray();
        System.out.println("Byte[] logo:" + imageByteArray.length);
        is = new ByteArrayInputStream(imageByteArray);
        return is;
    } catch (Exception e) {
        System.out.println("Error reading logo.");
        e.printStackTrace();
    }
    return is;
}