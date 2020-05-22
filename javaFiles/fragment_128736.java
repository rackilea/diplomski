private void installMouseListenerWrapper(JComponent tabbedPane) {
    MouseListener handler = findUIMouseListener(tabbedPane);
    tabbedPane.removeMouseListener(handler);
    tabbedPane.addMouseListener(new MouseListenerWrapper(handler));
}

private MouseListener findUIMouseListener(JComponent tabbedPane) {
    MouseListener[] listeners = tabbedPane.getMouseListeners();
    for (MouseListener l : listeners) {
        if (l.getClass().getName().contains("$Handler")) {
            return l;
        }
    }
    return null;
}

public static class MouseListenerWrapper implements MouseListener {

    private MouseListener delegate;

    public MouseListenerWrapper(MouseListener delegate) {
        this.delegate = delegate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        delegate.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) return;
        delegate.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        delegate.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        delegate.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        delegate.mouseExited(e);
    }

}