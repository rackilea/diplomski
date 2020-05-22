public void removeNotify() {
    JRootPane root = SwingUtilities.getRootPane(this);
    if (root != null && root.getDefaultButton() == this) {
        root.setDefaultButton(null);
    }
    super.removeNotify();
}