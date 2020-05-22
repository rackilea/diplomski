public class CustomScroll extends JComponent implements Scrollable {

    private Dimension preferredScrollableViewportSize = new Dimension(266, 300);

    public CustomScroll() {
    }

    public void setPreferredScrollableViewportSize(Dimension size) {
        this.preferredScrollableViewportSize = size;
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return preferredScrollableViewportSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
                    int orientation, int direction) {
        return 64;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
                    int orientation, int direction) {
        return 64;
    }
}