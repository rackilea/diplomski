public class Test extends Thread {
    public static void main(String[] args) throws Exception {
        test(new Vector<>());
        test(new ArrayList<>());
        test(Collections.synchronizedList(new ArrayList<>()));
        test(new CopyOnWriteArrayList<>());
    }
    private static void test(final List<Integer> list) throws Exception {
        System.gc();
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++)
            threads[i] = new Test(list);
        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads)
            thread.join();
        long end = System.currentTimeMillis();
        System.out.println(list.size() + " in " + (end - start) + "ms using " + list.getClass().getSimpleName());
    }
    private final List<Integer> list;
    Test(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++)
                this.list.add(i);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}