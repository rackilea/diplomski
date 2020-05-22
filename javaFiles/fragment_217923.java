import java.lang.reflect.*;

public class Test {

    public Test(int x) {
        System.out.println("Constuctor called! x = " + x);
    }

    // Don't just declare "throws Exception" in real code!
    public static void main(String[] args) throws Exception {
        Class<Test> clazz = Test.class;
        Constructor<Test> ctor = clazz.getConstructor(int.class);
        Test instance = ctor.newInstance(5);           
    }
}