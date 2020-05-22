@Stateless(name="myEJB")
public class MyEJB {

  public void ejbMethod() {
  // business logic
  }

}

public class TestEJB {

  public static void main() {
  MyEJB ejbRef = (MyEJB) new InitialContext().lookup("java:comp/env/myEJB");
  ejbRef.ejbMethod();
  }
}