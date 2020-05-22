@Aspect
public class TrackMyClassInvoke {
    @Before("execution(* MyClass.invoke())")
    public void beforeInvoke() {
         // do something to track it here
    }
}