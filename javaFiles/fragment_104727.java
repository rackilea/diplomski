jTable.getParent().addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(final ComponentEvent e) {
        if (jTable.getPrefer1sredSize().width < jTable.getParent().getWidth()) {
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
    }
});