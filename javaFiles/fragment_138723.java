@Aspect
public class BeforeVisitProgram {

    @Before("visitProgram()")
    public void doStuff() {
      // break in here
    }

}