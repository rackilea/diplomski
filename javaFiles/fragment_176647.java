public abstract class BaseBuilder <T, B> {

  abstract public B getB();

  public B setB1(String b1) {
    this.b1 = b1;
    return getB();
  }

  abstract public T build();

  String b1;
}