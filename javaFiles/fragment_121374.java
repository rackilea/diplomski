try {
    frame.setIconImage(ImageIO.read(new File("res/icon.png")));
}
catch (IOException exc) {
    exc.printStackTrace();
}