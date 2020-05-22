window = new JFrame("Window");
window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
window.add(Box.createVerticalGlue());
window.add(Box.createHorizontalGlue());

displayBox = new JTextField(20);
display = new JPanel();

buttons = new JPanel();
buttons.setLayout(new GridLayout(0, 3));

b0 = new JButton("0");
b1 = new JButton("1");
//...

window.getContentPane().add(display);
display.add(displayBox);

window.getContentPane().add(buttons);
buttons.add(b0);
buttons.add(b1);
//...

window.pack();
window.setSize(300, 400);
window.setVisible(true);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);