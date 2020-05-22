int numberOfMonitors = 0;
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();
for (int j = 0; j < gs.length; j++) {
    GraphicsDevice gd = gs[j];
    GraphicsConfiguration[] gc = gd.getConfigurations();
    if (gc.getType() == TYPE_RASTER_SCREEN) numberOfMonitors++;
}
System.out.println("Number of monitors: " + numberOfMonitors);