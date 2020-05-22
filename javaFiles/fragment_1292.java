public void createAndShowGUI() {
    setTitle("Transparent Panel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setUndecorated(true);
    AWTUtilities.setWindowOpaque(this, false);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 315, 610);

    JLabel mobileImageLabel = new JLabel(new ImageIcon("C://Mobile.png"));
    mobileImageLabel.setBounds(0, 0, 315, 610);
    layeredPane.add(mobileImageLabel, Integer.valueOf(0));

    JLabel textLabel = new JLabel(" Booting... ");
    textLabel.setVerticalAlignment(SwingConstants.TOP);
    textLabel.setForeground(Color.GREEN);
    textLabel.setBounds(26, 59, 263, 495);
    layeredPane.add(textLabel, Integer.valueOf(1));

    setContentPane(layeredPane);

    setSize(315, 610);
    setLocation(800, 100);
    setVisible(true);
}