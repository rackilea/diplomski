@Aspect
public class ExampleAspect {

    @Pointcut("execution(@org.junit.Test * *(..)) && !within(ExampleAspect)")
    public void testPointCut() {
    }

    @Pointcut("call(@com.example.Example * *(..))")
    public void examplePointCut() {
    }

    @After("cflow(testPointCut()) && examplePointCut()")
    public void doSomething(JoinPoint joinPoint, EnclosingStaticPart enclosingStaticPart) {
        System.out.println(joinPoint.getSignature() + " was invoked from "
            + enclosingStaticPart.getSignature());
    }

}