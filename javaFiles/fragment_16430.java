JFrame f = new JFrame();
f.setLayout(new BorderLayout());
JPanel p = new JPanel();
JPanel p2 = new JPanel();
JPanel p3 = new JPanel(new BorderLayout());
JButton b = new JButton("Edit/Add Data");
JButton c = new JButton("Web Records Viewer");

p.add(b);
p.add(c);
f.add(p, BorderLayout.CENTER);

JButton d = new JButton("Logout");

p2.add(d);
p3.add(p2, BorderLayout.EAST);
f.add(p3, BorderLayout.SOUTH);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.pack();
f.setVisible(true);