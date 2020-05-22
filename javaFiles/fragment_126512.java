public static void main(String[] args) throws Exception {

    BufferedImage originalImage = ImageIO.read(inputFile);
    BufferedImage newImage = orgiginalImage;
    int[] pixels = ((DataBufferInt)newImage.getRaster().getDataBuffer()).getData();

    for(int i = 0; i < pixels.length; i++){
        // Code for changing pixel data;
        pixels[i] = 0xFFFFFFFF // White
        // Syntax for setting pixel color: 0x(HEX COLOR CODE)
        // There is no need to set these pixels to the image; they are allerady linked
        // For instance, if you create a Canvas object in a JFrame, 
        // and used graphics.drawImage(newImage, 0, 0,
        // newImage.getWidth(), newImage.getHeight(), null), it will be up to date
        // Another example is, if you saved newImage to a file, it willallready have
        // the white pixels drawn in.
    }

}