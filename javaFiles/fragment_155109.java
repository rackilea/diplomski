JSplitPane pane = new JSplitPane(JSPlitPane.HORIZONTAL_SPLIT, panelOne, panelTwo);
pane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        // some processing here
    }
});