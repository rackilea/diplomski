public abstract class Parent {

  private static class Child extends Parent {}

  public static void main(String[] args) throws Exception {
    Parent[] array = new Parent[1];
    array[0] = new Child();
  }
}