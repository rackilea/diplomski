canvas.getLayer().addPropertyChangeListener(PNode.PROPERTY_CHILDREN, new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        System.out.println("notify");
    }
});