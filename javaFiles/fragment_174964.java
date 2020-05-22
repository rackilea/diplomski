class Food extends Item {

  public Food(double price, String name) {
    super(price, name);
  }

  @Override
  void discount(double amount) {
    this.price -= amount;
  }
}

class Bevarage extends Item {

  public Bevarage(double price, String name) {
    super(price, name);
  }

  @Override
  void discount(double amount) {
    this.price -= amount;
  }
}