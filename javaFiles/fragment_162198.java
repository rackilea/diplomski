public KnoppenPanel() {

    b = new JButton("Open");
    add(b);
    b.addActionListener(this);

    b2 = new JButton("Gesloten");
    add(b2);
    b2.addActionListener(this);
}