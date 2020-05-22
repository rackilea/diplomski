public class ParentNodeObject implements NodeObject {
    private final String display;

    public ParentNodeObject(final String display) {
        this.display = display;
    }

    /**
     * Override so that we control what is display on the Node
     */
    @Override
    public String toString() {
        return display;
    }

    @Override
    public void onSingleClick() {
        // Do nothing
    }

    @Override
    public void onDoubleClick() {
        // Do nothing
    }
}

public class LeafNodeObject implements NodeObject {
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

    @Override
    public void onSingleClick() {
        // Do nothing
    }

    @Override
    public void onDoubleClick() {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}