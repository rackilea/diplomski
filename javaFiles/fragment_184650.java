public class Driver {
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.foo();
        sc = null;
        System.gc();        
    }
}