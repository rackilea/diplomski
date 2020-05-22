public class test {
    public static void main(String[] args) throws Exception {
        final AtomicInteger num = new AtomicInteger(111);
        new Thread() {
            @Override
            public void run() {
                num.set(222);
            }
        }.start();
    }
}