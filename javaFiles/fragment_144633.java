// @see javax/swing/SwingUtilities.java
public static void updateComponentTreeUI(Component c) {
    updateComponentTreeUI0(c);
    c.invalidate();
    c.validate();
    c.repaint();
}
private static void updateComponentTreeUI0(Component c) {
    if (c instanceof JComponent) {
        JComponent jc = (JComponent) c;
        jc.updateUI();
        JPopupMenu jpm =jc.getComponentPopupMenu();
        if(jpm != null) {
            updateComponentTreeUI(jpm);
        }
    }
    Component[] children = null;
    if (c instanceof JMenu) {
        children = ((JMenu)c).getMenuComponents();
    }
    else if (c instanceof Container) {
        children = ((Container)c).getComponents();
    }
    if (children != null) {
        for (Component child : children) {
            updateComponentTreeUI0(child);
        }
    }
}