private static class ProxyDesktopManager implements DesktopManager {

    private final DesktopManager delegate;

    public ProxyDesktopManager(DesktopManager delegate) {
        this.delegate = Objects.requireNonNull(delegate);
    }

    // Check whether frame is moveable
    private boolean checkFrameMovable(JComponent frame) {
        if (frame instanceof JInternalFrame) {
            // TODO check whether the frame if movable

        }
        return false;
    }

    @Override
    public void beginDraggingFrame(JComponent f) {
        if (checkFrameMovable(f)) {
            delegate.beginDraggingFrame(f);
        }
    }

    @Override
    public void dragFrame(JComponent f, int newX, int newY) {
        if (checkFrameMovable(f)) {
            delegate.dragFrame(f, newX, newY);
        }
    }

    @Override
    public void endDraggingFrame(JComponent f) {
        if (checkFrameMovable(f)) {
            delegate.endDraggingFrame(f);
        }
    }

    @Override
    public void openFrame(JInternalFrame f) {
        delegate.openFrame(f);
    }

    @Override
    public void closeFrame(JInternalFrame f) {
        delegate.closeFrame(f);
    }

    @Override
    public void maximizeFrame(JInternalFrame f) {
        delegate.maximizeFrame(f);
    }

    @Override
    public void resizeFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
        delegate.resizeFrame(f, newX, newY, newWidth, newHeight);
    }

    // IMPORTANT: simply delegate all another methods like openFrame or 
    // resizeFrame
}