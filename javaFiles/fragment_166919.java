public class ShrinkableHBox extends HBox {

    private final int unshrinkableCount;

    public ShrinkableHBox(int unshrinkableCount) {
        final Rectangle clip = new Rectangle();
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());
        setClip(clip);
        this.unshrinkableCount = unshrinkableCount;
    }

    @Override
    protected double computeMinWidth(double height) {
        Insets insets = getInsets();
        height -= insets.getTop() + insets.getBottom(); 
        double width = insets.getLeft() + insets.getRight();

        List<Node> children = getManagedChildren();

        int unshrinkableCount = Math.min(children.size(), this.unshrinkableCount);

        // only consider the first unshrinkableCount children for minWidth computation
        if (unshrinkableCount > 1) {
            width += getSpacing() * (unshrinkableCount - 1);
        }

        for (int i = 0; i < unshrinkableCount; i++) {
            width += children.get(i).minWidth(height);
        }

        return width;
    }

}