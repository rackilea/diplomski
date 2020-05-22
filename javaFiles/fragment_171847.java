import javax.imageio.ImageIO;

/*       * Convert an image to a byte array
         */
    private byte[] convertImageToByteArray (String ImageName)throws IOException {

        byte[] imageInByte;
        BufferedImage originalImage = ImageIO.read(new File(ImageName));

        // convert BufferedImage to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        imageInByte = baos.toByteArray();
        baos.close();

        return imageInByte;
    }