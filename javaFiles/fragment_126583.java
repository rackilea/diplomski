GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gd = ge.getDefaultScreenDevice();

GraphicsConfiguration gc = gd.getDefaultConfiguration();
Rectangle bounds = gc.getBounds();

JFrame gui = new JFrame("Changeable Resolution");
gui.setSize(bounds.width, bounds.height);
gui.setLocation(bounds.x, bounds.y);
gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);
gui.setVisible(true);