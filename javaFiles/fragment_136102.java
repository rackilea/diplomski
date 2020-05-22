private static JLabel label;

private static void createFrame(){

    JFrame sos0 = new JFrame();
    sos0.setVisible(true);
    sos0.setSize(500, 400);
    sos0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sos0.setTitle("This is a frame");
    sos0.setLocationRelativeTo(null);
    sos0.setLayout(new GridBagLayout());

    label = new JLabel("test");
    sos0.add(label);

}