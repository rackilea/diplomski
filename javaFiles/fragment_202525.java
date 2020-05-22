BufferedImage viewPort;
...
try {
    viewPort = ImageIO.read(getClass().getResource("/pictures/viewport.png"));
} catch (IOException ex) { 
    // print some message 
}