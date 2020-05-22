public class ScrollPaneWidthTrackingPanel extends JPanel implements Scrollable {
    private static final long serialVersionUID = 1L;

    public ScrollPaneWidthTrackingPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return Math.max(visibleRect.height * 9 / 10, 1);
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return Math.max(visibleRect.height / 10, 1);
    }
}