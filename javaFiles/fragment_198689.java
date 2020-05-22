import org.testng.annotations;

public aspect TestExceptionInterceptor {
    pointcut testMethod(): execution(@Test * *(..));

    after() throwing (AssertionError e): testMethod() {
        System.out.println(thisJoinPointStaticPart.getSignature());
    }
}