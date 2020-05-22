// If an image is on the system clipboard, this method returns it;
// otherwise it returns null.
public static Image getClipboard() {
    Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

    try {
        if (t != null && t.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            Image text = (Image)t.getTransferData(DataFlavor.imageFlavor);
            return text;
        }
    } catch (UnsupportedFlavorException e) {
    } catch (IOException e) {
    }
    return null;
}