public class Test { 
    @BeforeMethod
    public void handleTestMethodName(java.lang.reflect.Method method) {
        GlobalVariables.currentTestName = method.getName(); 
    }
...
}