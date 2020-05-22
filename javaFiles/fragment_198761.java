@Component
public interface JustToCheck {
    @Flip(name="check-no-logging", alterBean="just-to-check")
    void log2();
}

@Component("just-to-check")
public class JustToCheckImpl implements JustToCheck {
   public void log2() {
       System.out.println("hello2");
    }
}

@Component("just-to-check-mock")
public class JustToCheckMock implements JustToCheck {

  public void log2() {
    System.out.println("As check-no-logging is disable... do nothing");
  }
}