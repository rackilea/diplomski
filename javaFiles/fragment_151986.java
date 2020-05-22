public class A{
    private static final int x = 5;
    private final int        y;

    A(int z) {
        y = z;
    }

    public void f() throws Exception {
        if (y <= x) {
            throw new Exception();
        }
    }

    public static void main(String args[]) {
        A a = new A(2);
        try {
            a.f();
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}