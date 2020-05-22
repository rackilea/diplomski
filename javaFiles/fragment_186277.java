public class Launcher extends Application {

  Thread gameThread;

  int renderFPS = 30; // 

  int processPPS = 10;
  // five processings per second (around 1000 / 10 = 100 msec between each)

  boolean running;

  Game game;

  public static void main(String[] args) {
    // here goes the initialization
    Launcher launcher = new Launcher();
    launcher.launch();
  }

  public void launch() {
    running = false;

    // instantiating game object
    game = new Game();

    // creating thread
    gameThread = new Thread(new Runnable() {

      @Override
      public void run() {
        // this code will be executed in thread

        running = true;
        // here goes the rendering/processing "meat";
        long lastIteration = System.currentTimeMillis();
        long lastRender = lastIteration;
        long lastProcess = lastIteration;

        long msecPerRender = 1000 / renderFPS;
        long msecPerProcess = 1000 / processPPS;

        // main game loop
        while (running) {
          long now = System.currentTimeMillis();

          // should we draw next frame?
          long delta = now - lastRender;
          if (delta >= msecPerRender) {
            lastRender = now - (delta - msecPerRender);
            game.render(lastRender);
          }

          // is it time for processing next game iteration?
          delta = now - lastProcess;
          if (delta >= msecPerProcess) {
            lastProcess = now - (delta - msecPerProcess);
            game.process(lastProcess);
          }
        }
      }
    });

    // start the thread
    gameThread.start();

    // in order to keep app running, we should wait for thread execution finished
    try {
      gameThread.join();
    } catch (InterruptedException ex) {
    }
  }

  // to stop the application execution
  public void stop() {
    running = false;
  }

  // here you can move yours player
  public void movePlayer() {
    boolean moveUp = true; // calc direction
    if (moveUp)
      game.player.moveVertically(1);
    else
      game.player.moveVertically(-1);
  }

}