package test;

@Aspect
public class TestAspect {
    public static String createMultiLabel(final String msg) {
        return msg;
    }
    public static void main(String[] args) {
        String st1 = createMultiLabel("hello");
        System.out.println(st1);
    }

    @Around("execution(java.lang.String test.TestAspect.createMultiLabel(java.lang.String))")
    public String aroundCreateMultiLabel(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("in around before " + joinPoint);
        String string = (String) joinPoint.proceed();
        System.err.println("in around after " + joinPoint);
        return string;
    }
}