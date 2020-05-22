//toolbar
JMenu fileMenu = new JMenu("File");

exit = new JMenuItem("Exit");

fileMenu.add(new JMenuItem("About"));
fileMenu.add(exit);

menubar = new JMenuBar();
menubar.add(fileMenu);
setJMenuBar(menubar);