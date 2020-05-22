public class JavaMain {
    public static void main(String[] arrstring) {
        A a;
        A a2 = a = new A();
        a2.getClass();
        A.B b = new A.B(a2, a);
    }
}