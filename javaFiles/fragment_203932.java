class Game extends Canvas {
    //the items used between render and update
    Player player;
    Enemy player;

    //render values
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        g.fillRect(player.x, player.y, 50, 50);

        g.setColor(Color.RED);
        g.fillRect(enemy.x, enemy.y, 50, 50);
    }

    //affect values
    public void update() {
         player.x++;
    }
}