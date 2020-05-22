static {
    Image up_arrow = null;
    try {
        up_arrow = ImageIO.read(new File("img/upArrow.png"));
    }
    catch(IOException ioe) {
        // log the error?
    }
    UP_ARROW = up_arrow;
}