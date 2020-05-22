public class UnsafePublication {

    static Foo foo;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (foo == null) {}
                if (!"abc".equals(foo.getBar())) System.out.println("unsafe");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                foo = new Foo("abc");
            }
        }).start();
    }
}