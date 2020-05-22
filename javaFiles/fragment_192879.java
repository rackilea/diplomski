@Aspect
public class TaskDoer {

  @After("@annotation(doTaskAnnotation)")
  // or @AfterReturning or @AfterThrowing
  public void doSomething(DoTaskAtMethodReturn doTaskAnnotation) throws Throwable {
    // do what you want to do
    // if you want access to the source, then add a 
    // parameter ProceedingJoinPoint as the first parameter
  }
}