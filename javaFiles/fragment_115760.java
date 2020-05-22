JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());
JMenuBar menuBar = new JMenuBar();
JMenu menu = new JMenu("Test");
JMenuItem item = new JMenuItem("test2");
menu.add(item);
menuBar.add(menu);
frame.add(menuBar, BorderLayout.NORTH);