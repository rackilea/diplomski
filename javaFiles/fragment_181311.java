public static ImageIcon getImageIconResource(String fileName) {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    InputStream is = classLoader.getResourceAsStream("img/" + fileName);
    Image image = ImageIO.read(is);
    return new ImageIcon(image);
}