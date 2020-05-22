public class LeafNodeObject {
    private final URI uri;

    public LeafNodeObject(final String display, final URI uri) {
        this.display = display;
        this.uri = uri;
    }

    /**
     * Override so that we control what is display on the Node
     */
    @Override
    public String toString() {
        return display;
    }

    public void onDoubleClick() {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}