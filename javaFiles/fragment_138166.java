interface Fruit {
  public String getName();
}

abstract class FruitImpl  {
  private final String name;
  public FruitImpl(name) {
    this.name = name;
  }

  public final String getFruitName(){
    return name;
  }