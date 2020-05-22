public class run extends Functor {
    public static void main(String[] argv) {
        System.loadLibrary("test");
        test.make_functor().call(1,2.5);

        new Functor(test.add_and_print_cb).call(3,4.5);

        Functor f = new run();
        test.do_things(f);
    }

    @Override
    public void call(int a, double b) {
        System.out.println("Java: " + a + ", " + b);
    }
}