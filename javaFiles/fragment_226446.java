JTabbedPane tabs = new JTabbedPane();

JFrame frame = new JFrame();
JMenuBar bar = new JMenuBar();
bar.add(new JMenu("menu"));
frame.setJMenuBar(bar);
frame.add(new JButton("button"));

JPanel tab1 = new JPanel(new BorderLayout());
tab1.add(frame.getJMenuBar(),BorderLayout.NORTH);
tab1.add(frame.getContentPane());
tabs.addTab("1", tab1);