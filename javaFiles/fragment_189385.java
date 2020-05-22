public class AImpl implements A {}
public class User {
  public User() {
    A a = new AImpl();
    A$class.$init$(a);
  }
}