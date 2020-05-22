private static ImageIcon getImage(String filename) {
    ImageIcon imageIcon = null;
    try {
        URL url = PacMan.class.getResource(filename);
        Image image = ImageIO.read(url);
        imageIcon = new ImageIcon(image);
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    return imageIcon;
}