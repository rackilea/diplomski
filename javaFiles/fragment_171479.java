import java.lang.reflect.Method;

public class Test {

    @BeforeMethod
    public void handleTestMethodName(Method method){
        String testName = method.getName(); 
    }

}