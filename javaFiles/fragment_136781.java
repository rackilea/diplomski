public CustomList() {
    for (int i = 0; i < 10; i++) {

        JPanel panel = new JPanel(new BorderLayout());
        JButton b = new JButton("Button item" + i);
        //b.setMaximumSize(new Dimension(0,0));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(b);
        box.add(panel);
    }
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    add(box, BorderLayout.CENTER);
}