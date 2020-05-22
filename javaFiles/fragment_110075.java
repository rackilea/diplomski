public static class JImagePanel extends JPanel implements Scrollable {

    private BufferedImage image;

    public JImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage scaled = //new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                GraphicsUtilities.createCompatibleImage(getWidth(), getHeight());
        Graphics2D g2 = scaled.createGraphics();
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(scaled, 0, 0, this);
        g2.dispose();
    }

    /**
     * This method is used for laying out this container
     * inside the Viewport: let it return the "real" pref
     * or min, depending on whether or not the scrollbars
     * are showing.  
     */
    @Override
    public Dimension getPreferredSize() {
        Dimension size = getImageSize();
        if (!getScrollableTracksViewportWidth()) {
            size.width = getMinimumSize().width;
        }
        if (!getScrollableTracksViewportHeight()) {
            size.height = getMinimumSize().height;
        }
        return size;
    }

    @Override
    public Dimension getMinimumSize() {
        Dimension min = getImageSize();
        min.height /= 2;
        min.width /= 2;
        return min;
    }

    /**
     * This is used for laying out the scrollPane. Keep 
     * it fixed to "real" pref size.
     */
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getImageSize();
    }

    /**
     * The unscaled image size (aka: "real" pref)
     */
    protected Dimension getImageSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getParent() instanceof JViewport
                && getParent().getWidth() >= getMinimumSize().width;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getParent() instanceof JViewport
                && getParent().getWidth() >= getMinimumSize().width;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return getParent() instanceof JViewport
              && getParent().getHeight() >= getMinimumSize().height;        }


    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
            int orientation, int direction) {
        return 10;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
            int orientation, int direction) {
        return 100;
    }

}