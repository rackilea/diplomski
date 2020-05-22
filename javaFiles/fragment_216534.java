public class Example {
    static String y;
    static  {
         y = foo();
    }

    static String foo() {
        return x.toUpperCase();
    }

    public static final String x = "test";

    public static void main(String[] args) throws Exception {
        System.out.println(x);
        System.out.println(y);
    }
}