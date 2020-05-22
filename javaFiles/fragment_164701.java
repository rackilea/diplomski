public GameThread extends Thread {
  private Game game;

  GameThread(Game game) {
    this.game = game;
  }

  public void run() {
    game.logic();
  }
}

public static void main(String[] args) {
  GameThread thread = new GameThread(new Game());
  thread.start();
}