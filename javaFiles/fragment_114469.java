@Listeners({ com.somepackage.MethodInvocationListener.class })
public class GroupDemoChild extends GroupDemo{

   @Test
   @AfterEd
   public void atest(){
       System.out.println("atest");
   }
}

public class MethodInvocationListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        // doNothing
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.getTestMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(AfterEd.class) != null) {
                System.out.println("after method");
        }
    }
}