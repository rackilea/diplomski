public class Testing {
    public static void main (String[] args) {
        Sub.main(args);
        System.out.println(Super.foo);
        System.out.println(Sub.foo);
        System.out.println(Super.foo);
    }
}