public class PlaceHolderIcon implements Icon {

    private final int width;
    private final int height;

    public PlaceHolderIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getIconHeight() {
        return height;
    }

    public int getIconWidth() {
        return width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
    }
}