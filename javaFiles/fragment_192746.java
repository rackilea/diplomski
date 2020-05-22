TestPane tp = new TestPane();
CopyAction copyAction = new CopyAction(tp.getListOfStuff());

JMenuBar mb = new JMenuBar();
JMenu menu = new JMenu("Edit");
mb.add(menu);
menu.add(copyAction);

JFrame frame = new JFrame("Testing");
frame.setJMenuBar(mb);