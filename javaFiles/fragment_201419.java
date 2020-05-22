ImageIcon[] images = new ImageIcon[] {
        new ImageIcon("foo.gif"),
        new ImageIcon("bar.gif"),
        new ImageIcon("blub.gif")
};

JFrame frame = new JFrame("Test");
frame.getContentPane().setLayout(new FlowLayout());

JLabel label = new JLabel(images[0]);
frame.getContentPane().add(label);

JButton button1 = new JButton("Image 1");
button1.addActionListener(e -> label.setIcon(images[0]));
frame.getContentPane().add(button1);

JButton button2 = new JButton("Image 2");
button2.addActionListener(e -> label.setIcon(images[1]));
frame.getContentPane().add(button2);

frame.pack();
frame.setVisible(true);