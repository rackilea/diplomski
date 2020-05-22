public static void main(String[] args) {
    int width = 1085;
    int height = 696;
    byte[] imageInByteArr = new byte[width ];
    BufferedImage convertedGrayScale = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    convertedGrayScale.getRaster().setDataElements(0, 0, width, height, imageInByteArr);

}