public class GameClass extends JPanel implements ActionListener, KeyListener{
    Player player = new Player();
    Enemy enemy = new Enemy(player);
    //...
}

public class Enemy {
  //...
  Player player;

  public Enemy(Player player) { this.player = player; }
  //...
}