public void createAndShowGUI() {
    JPanel panel = new JPanel(new GridLayout(5,5));
    panel.add(new GameField("Button # 1").getButton());
    panel.add(new GameField("Button # 2").getButton());
    ...
    JFrame frame = new JFrame("Game");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}