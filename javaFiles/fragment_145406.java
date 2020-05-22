private static void swap(JSplitPane split) {
    Component r = split.getRightComponent();
    Component l = split.getLeftComponent();

    // remove the components
    split.setLeftComponent(null);
    split.setRightComponent(null);

    // add them swapped
    split.setLeftComponent(r);
    split.setRightComponent(l);
}