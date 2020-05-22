innerScrollPane.addMouseWheelListener(new MouseWheelListener() {

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        innerScrollPane.getParent().dispatchEvent(e);
    }
});