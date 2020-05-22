private void getMyComponents() {
    Component findList = getJList(chooser);
    JList myList = (JList) findList;
    //find fileName in the JList and move with ViewPort view to the expected Rectangle
    Component myScrollPane = getJScrollPane(chooser);
    JScrollPane scrollPane = (JScrollPane) myScrollPane;
    JViewport vport = scrollPane.getViewport();
    //move with ViewPort view to the expected Rectangle
}

private Component getJList(Component comp) {
    if (comp.getClass() == JList.class) {
        return comp;
    }
    if (comp instanceof Container) {
        Component[] components = ((Container) comp).getComponents();
        for (int i = 0; i < components.length; i++) {
            Component child = getJList(components[i]);
            if (child != null) {
                return child;
            }
        }
    }
    return null;
}

private Component getJScrollPane(Component comp) {
    if (comp.getClass() == JScrollPane.class) {
        return comp;
    }
    if (comp instanceof Container) {
        Component[] components = ((Container) comp).getComponents();
        for (int i = 0; i < components.length; i++) {
            Component child = getJScrollPane(components[i]);
            if (child != null) {
                return child;
            }
        }
    }
    return null;
}