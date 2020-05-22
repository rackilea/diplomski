Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//Get data from clipboard and assign it to an image.
//clipboard.getData() returns an object, so we need to cast it to a BufferdImage.
BufferedImage image = (BufferedImage) clipboard.getData(DataFlavor.imageFlavor);

if (isMac()) {
    image = getBufferedImage(image);
}