private void initGui() {
    mainFrame = new JFrame("Test Frame");
    mainFrame.setSize(800, 600);
    mainFrame.setLayout(null);

    AL1 = new JRadioButton("Radio");
    AL1.setSize(100, 100);
    AL1.setVisible(true);
    AL1.setLocation(50, 50);
    mainFrame.add(AL1);

    mainFrame.setVisible(true);
}