import java.lang.reflect.*;

public class Test {

    public String methodName(int i) {
        return "Hello World: " + i;
    }

    public static void main(String... args) throws Exception {
        Test t = new Test();
        Method m = Test.class.getMethod("methodName", int.class);
        String returnVal = (String) m.invoke(t, 5);
        System.out.println(returnVal);
    }
}