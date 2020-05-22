public class Abc {
    public static void main(String[] args) {
        A ob = new A();

        Field[] f;
        String[] s;
        f = ob.getClass().getDeclaredFields();

        System.out.println(f.length);

        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName());
        }
    }
}
class A {
    private int x = 10;
    String st = "hii";
}