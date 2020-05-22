public Player(Game game, int left, int right, int x) {
    this.game = game;
    this.x = x;
    y = game.getHeight() - 20;
    //...
    this.y = y;
    x = game.getWidth() - 36;
}