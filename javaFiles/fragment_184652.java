public class Driver {

    public static void main(String[] args) {
        OverridenSubClass sc = new OverridenSubClass();
        sc.foo();
        System.out.println(sc.toString());
        sc = null;
        System.gc();
        System.exit(0);
    }
}