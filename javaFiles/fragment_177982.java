protected BufferedImage image;

public MyPanel() throws IOException {
    URL imageURL = getClass().getResource("/ax.jpeg");
    if (imageURL == null) {
        throw new FileNotFoundException();
    }
    this.image = ImageIO.read(imageURL);
}