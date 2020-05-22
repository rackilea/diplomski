class Player {
  public int health;
  Player() {
    super();
    this.health = 10;
  }
  public void resetHealth() {
    this.health = 10;
  }
}

void setup() {
  Player p = new Player();

  //test, set lower health
  p.health = 3;
  println("lowed health to", p.health);

  //test, call reset health
  p.resetHealth();
  println("reset health to", p.health);
}