fr = new JFrame("BorderLayout");

// Which frame are you modifying now...??
setSize(300, 200);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

setLayout(bl);

label = new JLabel("Label 1");
label2 = new JLabel("Label 2");
label3 = new JLabel("Label 2");
add(label, BorderLayout.NORTH);
add(label2, BorderLayout.SOUTH);
add(label3, BorderLayout.CENTER);