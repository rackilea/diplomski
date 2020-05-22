public class A {
    private final static A instance = new A();

    /* private constructor forces you to use the getInstance() method below */
    private A() {}

    public static A getInstance() {
      return instance;
    }
}