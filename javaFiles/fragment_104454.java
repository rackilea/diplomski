private void updateComponent(Component c, FontUIResource resource) {
    if (c == null) {
        return;
    }
    if (c instanceof JComponent) {
        JComponent jc = (JComponent) c;
        jc.updateUI();
        JPopupMenu jpm = jc.getComponentPopupMenu();
        if (jpm != null) {
            updateComponent(jpm, resource);
        }
    }
    Component[] children = null;
    if (c instanceof JMenu) {
        children = ((JMenu) c).getMenuComponents();
    }
    else if (c instanceof Container) {
        children = ((Container) c).getComponents();
    }
    if (children != null) {
        for (Component child : children) {
            if (child instanceof Component) {
                updateComponent(child, resource);
            }
        }
    }
    int style = Font.PLAIN;
    Font f = c.getFont();
    if (f == null) {
        f = getFontUIResource(16); // default
    }
    if (f.isBold()) {
        style = Font.BOLD;
    }
    else if (f.isItalic()) {
        style = Font.ITALIC;
    }

    if (c instanceof JEditorPane) {
        ((JEditorPane) c).putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }
    c.setFont(resource.deriveFont(style));
}