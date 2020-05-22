public Display(Game game){
    super("PingPong");
    screenSize = new Dimension(500, 400);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    game.setPreferredSize(screenSize);

    setLocationRelativeTo(null);
    add(game);
    pack();
    setVisible(true);
    game.start();
}