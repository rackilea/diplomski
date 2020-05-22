public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet hw4 = new HW4();
    hw4.init();
    hw4.start();
    frame.add(hw4);
    frame.setSize(FramePanelDim);
    frame.setTitle("My Painter");
    //frame.setLayout(new BorderLayout(FrameHGap, FrameVGap));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    //frame.setResizable(false);
    //frame.setAlwaysOnTop(true);
    frame.setVisible(true);
    frame.pack();
}