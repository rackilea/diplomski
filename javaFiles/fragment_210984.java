public class Main {

    private String foo = "foo";

    public void method() {
        System.out.println(foo);
        new Object() {
            public void bar() {
                foo = "bar";
                System.out.println(foo);

            }
        }.bar();

        System.out.println(foo);
    }

    public static void main(String[] args) {
        Main t = new Main();
        t.method();
    }
}