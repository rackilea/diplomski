(throws IOException)

Image image = null;
try {
    URL url = new URL("http://www.yahoo.com/image_to_read.jpg");
    image = ImageIO.read(url);
} catch (IOException e) {
}