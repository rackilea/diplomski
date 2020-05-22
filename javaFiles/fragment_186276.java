class Game {

  Grid grid;
  ArrayList<Entity> entities;
  long lastProcess;

  public Game() {
    grid = new Grid(30, 20);
  }

  public void newGame() {
    lastProcess = 0;
    entities = new ArrayList<>();
  }

  public void render(long timemillis) {
    grid.render(timemillis);

    for (Entity entity : entities)
      entity.render(timemillis);
  }

  public void process(long timemillis) {
    grid.process(timemillis); // process grid (like, some animation)

    for (Entity entity : entities) // process entities
      entity.process(timemillis);

    if (timemillis - lastProcess > 300) { // each 300 msec ()
      lastProcess = timemillis;

      Entity spawn;

      // choose and spawn some random object
      switch (((int)(Math.random() * 10)) % 4) {
      case 0: // spawn G
        spawn = new G(this); break;
      case 1: // spawn Enemy
        spawn = new Enemy(this); break;
      case 2: // spawn Bonus
        spawn = new Bonus(this); break;
      case 3: // spawn Secret
        spawn = new Secret(this); break;
      }

      // spawn it at right grid edge (grid.w - 1) at random y position
      spawn.moveTo(grid.w - 1, (int)(Math.random() * 9999) % grid.h);
      entities.add(spawn);
    }
  }

}