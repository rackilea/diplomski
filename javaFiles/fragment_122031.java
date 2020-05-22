JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
tabbedPane.addMouseWheelListener(new MouseWheelListener() {
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        JTabbedPane pane = (JTabbedPane) e.getSource();
        int units = e.getWheelRotation();
        int oldIndex = pane.getSelectedIndex();
        int newIndex = oldIndex + units;
        if (newIndex < 0)
            pane.setSelectedIndex(0);
        else if (newIndex >= pane.getTabCount())
            pane.setSelectedIndex(pane.getTabCount() - 1);
        else
            pane.setSelectedIndex(newIndex);
    }
});