//this Display initialization is extracted from the Example app
Display d = new Display(vis);
d.setSize(720, 500); // set display size
// drag individual items around
d.addControlListener(new DragControl());
// pan with left-click drag on background
d.addControlListener(new PanControl()); 
// zoom with right-click drag
d.addControlListener(new ZoomControl());

// create a new window to hold the visualization
JFrame frame = new JFrame("prefuse example");
// ensure application exits when window is closed
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(d);
frame.pack();           // layout components in window
frame.setVisible(true); // show the window

//At the end: RUN THE CHART ACTION:
vis.run("myChartLayout");