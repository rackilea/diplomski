//size of the screen
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//height of the task bar
Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
int taskBarSize = scnMax.bottom;

//available size of the screen 
setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());