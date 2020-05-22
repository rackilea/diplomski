public static BufferedImage parseImage(String url) throws IOException {
    URL dest = new URL(url);
    if (url.endsWith(".ico")) {
        return ICODecoder.read(dest.openStream()).get(0);
    } else if (url.endsWith(".bmp")) {
        return BMPDecoder.read(dest.openStream());

    } else {
        return ImageIO.read(dest);
    }
}