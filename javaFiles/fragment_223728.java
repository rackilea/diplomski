GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
// Use this if need to know about a device which is not the default...
//GraphicsDevice lstGDs[] = ge.getScreenDevices();
GraphicsDevice device = ge.getDefaultScreenDevice();
GraphicsConfiguration cf = device.getDefaultConfiguration();
Rectangle bounds = cf.getBounds();

Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
bounds.x += insets.left;
bounds.y += insets.top;
bounds.width -= (insets.left + insets.right);
bounds.height -= (insets.top + insets.bottom);