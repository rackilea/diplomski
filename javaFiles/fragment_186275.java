class G extends Entity {

  // override parent process() method
  @Override
  public void process(long timemillis) {
    moveLeft(speed); // we should move left by amount, specified by "speed" 
  }

  @Override
  public void render(long timemillis) {
    // here goes rendering code for G entities
  }
}

class Enemy extends Entity {

  @Override
  public void render(long timemillis) {
    // here goes rendering code for Enemy entities
  }
}

class Bonus extends Entity {

  @Override
  public void render(long timemillis) {
    // here goes rendering code for Bonus entities
  }
}

class Player extends G {

  // override processing method if needed...
  @Override
  public void process(long timemillis) {
  }

  @Override
  public void render(long timemillis) {
    // here goes rendering code for player
  }
}