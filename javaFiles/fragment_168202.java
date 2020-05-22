public class A {
    public int a;

    public static void main(String [] args) {
        A var1 = new A();
        A var2 = var1;

        var1.a = 42;

        System.out.println("var2.a = " + var2.a);
    }
}