SwingUtilities.invokeLater(() -> {
    JFrame obj = new JFrame();
    Gameplay gamePlay = new Gameplay();
    obj.setBounds(10, 10, 700, 600);
    obj.setTitle("Brick Breaker");
    obj.setResizable(false);
    obj.setVisible(true);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    obj.add(gamePlay);
});