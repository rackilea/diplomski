@Component
public class DelegateBean {

  @Delegate("b")
  public void a(int i) {
    System.out.println("a: " + i);
  }

  public void b(int i) {
    System.out.println("b: " + i);
  }
}