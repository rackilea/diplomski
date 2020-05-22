public class A {
    static AtomicBoolean game_over = new AtomicBoolean();

    public static void main(String[] args) {
        B b = new B();
        Thread t = new Thread(b);
        t.start();

        while (!game_over.get()) {
            System.out.println("in the while-loop");
        }
        System.out.println("out of the while-loop");
    }
}