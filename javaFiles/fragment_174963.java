abstract class Item {

  protected double price;
  protected String name;

  public Item(double price, String name) {
    this.price = price;
    this.name = name;
  }

  public double getPrice() {
    return this.price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  abstract void discount(double amount);
}