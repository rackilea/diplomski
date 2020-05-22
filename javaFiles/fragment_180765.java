public class Main {

  public static void main(String[] args) {
    ChildA childA = new ChildA();
    ChildB childB = new ChildB();

    childA.example().childAMethod().example();
    childB.example().childBMethod().example();
  }
}