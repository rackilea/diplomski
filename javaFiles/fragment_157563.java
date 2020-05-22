public static JRootPane getRootPane(Component c) {
    if (c instanceof RootPaneContainer) {
        return ((RootPaneContainer)c).getRootPane();
    }
    for( ; c != null; c = c.getParent()) {
        if (c instanceof JRootPane) {
            return (JRootPane)c;
        }
    }
    return null;
}