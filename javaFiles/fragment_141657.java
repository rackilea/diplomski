fr = new JFrame("BorderLayout");

// Which frame are you modifying now...??
fr.setSize(300, 200);
fr.setVisible(true);
fr.setDefaultCloseOperation(EXIT_ON_CLOSE);

fr.setLayout(bl);

fr.label = new JLabel("Label 1");
fr.label2 = new JLabel("Label 2");
fr.label3 = new JLabel("Label 2");
fr.add(label, BorderLayout.NORTH);
fr.add(label2, BorderLayout.SOUTH);
fr.add(label3, BorderLayout.CENTER);