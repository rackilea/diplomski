public class Test {
    public static void main(String[] args) throws Exception {
        final int fakeConstructorArg = 10;

        Object a = new Object() {
            {
                System.out.println("arg = " + fakeConstructorArg);
            }
        };
    }
}