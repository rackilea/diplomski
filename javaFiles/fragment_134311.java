JFrame frame = new JFrame();
frame.setLayout(new FlowLayout());

final JTextArea area = new JTextArea(2,20);
frame.getContentPane().add(area);

JButton button1 = new JButton("press me");
JButton button2 = new JButton("press me");

button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        area.append("button 1 was pressed\n");
    }
});
button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        area.append("button 2 was pressed\n");
    }
});

frame.getContentPane().add(button1);
frame.getContentPane().add(button2);

frame.setSize(300,300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);