public BDisplay() {     
    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    gd = ge.getDefaultScreenDevice();

    frame = new Frame();
    frame.setResizable(false);
    frame.add(this);
    //frame.setLayout(null); // Why are you using a null layout?
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}