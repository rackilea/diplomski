tree.addPropertyChangeListener("dropLocation", new PropertyChangeListener() {
    public void propertyChange(PropertyChangeEvent pce) {
        dropOn = pce.getNewValue() != null;
    }
});

tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
    public void valueChanged(TreeSelectionEvent tse) {
        System.out.println(tse + " dropOn=" + dropOn);
    }
});