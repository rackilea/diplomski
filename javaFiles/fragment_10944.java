public static byte[] writeToByteArray(BufferedImage bi, String dImageFormat) throws IOException, Exception {
    byte[] scaledImageData = null;
    ByteArrayOutputStream baos = null;
    try {
        if(bi != null) {
            baos = new ByteArrayOutputStream();
            if(! ImageIO.write(bi, dImageFormat, baos)) {
                throw new Exception("no appropriate writer found for the format " + dImageFormat);
            }
            scaledImageData = baos.toByteArray();
        }
    } finally {
        if(baos != null) {
            try {
                baos.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    return scaledImageData;
}