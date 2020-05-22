public Testing() {
    super("hi");
    setBackground(Color.PINK);
    JPanel panel = new JPanel();

    JButton jb = new JButton();
    jb.setText("Here I am");
    Border line = new LineBorder(Color.PINK);
    Border margin = new EmptyBorder(5, 15, 5, 15);
    Border compound = new CompoundBorder(line, margin);
    jb.setOpaque(true);
    jb.setBorder(compound);
    jb.setBackground(Color.PINK);
    panel.setBackground(Color.PINK);
    panel.add(jb);
    add(panel);
    setVisible(true);
}