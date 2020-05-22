JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelOne, panelTwo);
BasicSplitPaneUI basicSplitPaneUI = (BasicSplitPaneUI) pane.getUI();
BasicSplitPaneDivider basicSplitPaneDivider = basicSplitPaneUI.getDivider();
basicSplitPaneDivider.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseDragged(MouseEvent e) {
        // some processing here
    }
});