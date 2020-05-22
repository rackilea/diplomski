public JPanel createContentPane() {
    buttonPanel = new JPanel();
    buttonPanel.setLayout(null);
    buttonPanel.setLocation(10, 50);
    buttonPanel.setSize(1370, 770);

    JButton Button1 = new JButton("Button 1");
    Button1.setLocation(0, 0);
    Button1.setSize(120, 30);
    buttonPanel.add(Button1);

    JTextField a = new JTextField(20);
    a.setLocation(125, 0);
    a.setSize(120, 30);
    buttonPanel.add(a);

    return buttonPanel;
}