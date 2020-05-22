public class Blah {
  private int foo;

  public Blah() { } // public no-args constructor
  public Blah(Blah b) { foo = b.foo; }  // copy constructor
}