class MyImage extends BufferedImage {
  int x, y, xa, ya;

  public Rectangle getBounds() {
    return new Rectangle(x, y, getWidth(), getHeight());
  }

// all other methods in raquet remain the same except you remove paint()

private Game game;

  public MyImage(Game game) {
    this.game = game;
  }

  public void move() {
    if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
        x = x + xa;
  }

  public void keyReleased(KeyEvent e) {
    xa = 0;
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
        xa = -1;
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        xa = 1;
  }


  public int getY() {
    return y;
  }
}