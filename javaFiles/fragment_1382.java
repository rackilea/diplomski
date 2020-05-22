public class Program {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(new Test2().getTest());
        Test.test = "changed";
        System.out.println(new Test2().getTest());
    }
}

abstract class Test {
    protected static String test = "test";
}

class Test2 extends Test {
    public String getTest() {
        return test;
    }
}