/*
 * Add Components to Frame
 */
setJMenuBar(menubar);
menubar.add(toolsmenu);
toolsmenu.add(nextpictureaction);

/*
 * Frame Properties
 */
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationByPlatform(true);
setSize(1000, 700);
setTitle("PictureEditor");
setVisible(true);