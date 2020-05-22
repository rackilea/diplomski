BufferedImage image = ImageIO.read(new File("BYO image"));
int width = image.getWidth();
int height = image.getHeight();
for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
        int pixel = image.getRGB(x, y);
        //value = 0xff000000 | rgba;
        int a = (pixel >> 24) & 0xff;
        Color color = new Color(pixel, true);
        System.out.println(x + "x" + y + " = " + color.getAlpha() + "; " + a);
    }
}