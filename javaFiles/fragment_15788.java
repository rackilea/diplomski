class Actor {
  public void act() {}
}

class HappyActor extends Actor {
  public void act() {print("HappyActor"); }
}

class Stage extends HappyActor {
  public void change() { /* Cannot change dynamic type */ }
  public void performPlay() {this.act(); } // call inherited act method
}