class FruitWrapper implements Fruit{
  private final String name;
  public FruitWrapper(Fruit fruit) {
    this.name = fruit.getFruitName();
  }

  public final String getFruitName(){
    return name;
  }