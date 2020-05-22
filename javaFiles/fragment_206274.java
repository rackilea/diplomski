public abstract class FruitTree {
  public abstract Object getFruit();
}
public class BananaTree {
  ...
  @Override public Banana getFruit() { return this.bananas.iterator().next(); }
}