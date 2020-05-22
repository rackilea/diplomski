class Grid {

  int w;
  int h;

  public Entity[][] cells;

  public Grid(int w, int h) {
    this.w = w;
    this.h = h;
    cells = new Entity[h][w];
  }

  public void process(long timemillis) {
    // here you can process grid

    // like, change some tiles, progress animations, etc
  }

  public void render(long timemillis) {
    // here you can draw grid
  }

}