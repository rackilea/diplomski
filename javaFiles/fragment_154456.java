private void addTabsInReverseOrder(final JTabbedPane pane) {
    for(int i = 0; i < 10; i++) {
        final String tabLabel = String.format("tab #%d", i);
        final String componentLabel = String.format("component #%d", i);

        final JLabel component = new JLabel(componentLabel);
        component.setName(componentLabel);

        pane.insertTab(tabLabel, null, component, null, pane.getTabCount()-i);
    }
}

private void dumpTabs(final JTabbedPane pane) {

    for(int i = 0; i < pane.getTabCount(); i++) {
        final String tabName = pane.getTitleAt(i);
        final Component component = pane.getComponentAt(i);

        final int componentIndex = pane.indexOfComponent(component);

        System.out.println(String.format("Index %d -> tab '%s' -> component '%s' -> component index %d", i, tabName, component.getName(), componentIndex));
    }
}