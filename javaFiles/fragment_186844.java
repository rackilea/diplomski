Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setUndecorated(true);
    frame.setSize(r.width, r.height);
    frame.setVisible(true);