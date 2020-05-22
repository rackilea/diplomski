public class ScrollableWrapper extends JPanel implements Scrollable {

    private Component wrapper;

    public ScrollableWrapper(Component wrapper) {
        setLayout(new BorderLayout());
        add(wrapper);
        this.wrapper = wrapper;
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return wrapper.getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 64;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 64;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

}