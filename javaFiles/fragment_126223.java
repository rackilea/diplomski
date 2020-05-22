public class Main {

    public static void main(String [] args) throws IOException {
        List<String> foo, bar, test;
        foo = new ArrayList<String>(Arrays.asList("foo")); 
        bar = new ArrayList<String>(Arrays.asList("bar"));
        test = new ArrayList<String>(Arrays.asList("test"));

        CountDownLatch cdl = new CountDownLatch(1);

        Thread r1 = new Thread(new MyThread("foo = new ArrayList(bar)", bar, foo, cdl));
        Thread r2 = new Thread(new MyThread("bar = new ArrayList(test)", test, bar, cdl)); 
        r1.start();
        r2.start();

        cdl.countDown();
        System.out.println("Size of foo is " + foo.size());
        System.out.println("Size of bar is " + foo.size());
    }
}

class MyThread implements Runnable {

    private List<String> src;
    private List<String> dst;
    private CountDownLatch cdl;
    private String msg;

    public MyThread(String msg, List<String> src, List<String> dst, CountDownLatch cdl) {
        this.msg = msg;
        this.src = src;
        this.dst = dst;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dst = new ArrayList<String>(src);
        dst.add("test");
        System.out.println(msg + " and my size is " + dst.size());
    }

}