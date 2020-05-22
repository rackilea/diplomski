public static class Player {
    //...
    public Player(GamePanel game, int left, int right, int x) {
        this.game = game;
        this.left = left;
        this.right = right;
        this.x = x;
        y = game.getHeight() - HEIGHT;
    }