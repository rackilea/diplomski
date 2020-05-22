JTable table = new JTable (12, 5);
JButton button = new JButton ("Button");

JPanel panel = new JPanel ();
panel.setLayout (new BorderLayout ());
panel.add (table, BorderLayout.CENTER);
panel.add (button, BorderLayout.SOUTH);

JTabbedPane tabbedPane = new JTabbedPane ();
tabbedPane.addTab ("Tab", panel);

JFrame frame = new JFrame ();
frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
frame.getContentPane ().setLayout (new BorderLayout ());
frame.getContentPane ().add (tabbedPane, BorderLayout.CENTER);
frame.pack ();
frame.setVisible (true);