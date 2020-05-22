public class Foo {

    public static void main(String[] args) throws Exception {
        foo(new int[]{1,2,3});
    }

    static void foo(Object o) {
        System.out.println("object");
    }

    static void foo(Object[] o) {
        System.out.println("array");
    }
}