public FlowPanel(int depth) {
    WrapLayout layout = new WrapLayout(FlowLayout.LEFT);
    layout.setMinWidth(300);
    setLayout(layout);
    setSize(new Dimension(300, 30));
}