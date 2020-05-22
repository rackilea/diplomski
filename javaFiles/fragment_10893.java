GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 GraphicsDevice[] gs = ge.getScreenDevices();

for (int j = 0; j < gs.length; j++) { 
    JFrame f = new JFrame(gs[j].getDefaultConfiguration());
    // Rest of the code
}