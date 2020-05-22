Frog() {
    panel.setBackground(Color.CYAN);
    panel2.setBackground(Color.GREEN);
    t = new JTextField("Frog is hungry", 10);
    panel2.add(t);
    panel2.add(button);
    frame.add(panel, BorderLayout.CENTER);
    frame.add(panel2, BorderLayout.PAGE_END);
    button.addActionListener(this);
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}