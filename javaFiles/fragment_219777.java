tree.addTreeSelectionListener(new TreeSelectionListener() {
    @Override // don't forget @Override annotation
    public void valueChanged(TreeSelectionEvent e) {
        File node = (File)e.getPath().getLastPathComponent(); // Look here!
        ...
    }
});