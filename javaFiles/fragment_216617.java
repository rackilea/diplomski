public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw Text
    g.drawString("This is my custom Panel!",10,20);

    JLabel c = new JLabel("Label");
    c.setBounds(0, 0, 400, 30);
    c.paint(g);
}