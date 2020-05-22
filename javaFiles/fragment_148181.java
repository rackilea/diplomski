/**
 * Implement a panel of type Scrollable to fine-tune its scrolling behaviour.
 * This implements the prefScrollableSize to the prefSize of the first child
 * and both block/unit increment to the height of the prefScrollable.
 */
public static class PageScrollable extends JPanel implements Scrollable {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        if (getComponentCount() > 0) {
            return getComponent(0).getPreferredSize();
        }
        return super.getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
            int orientation, int direction) {
        return getPreferredScrollableViewportSize().height;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
            int orientation, int direction) {
        return getPreferredScrollableViewportSize().height;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

}