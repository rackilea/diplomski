private static List<String> = new ArrayList<>();

public static void main(String[] args) {
    MainWatch R1 = new MainWatch("C:\\test", "Thread1", where);
    R1.start();
    MainWatch R2 = new MainWatch("C:\\test2", "thread2", where);
    R2.start();
}

public class MainWatch implements Runnable {
    ...
    private final List<String> where;

    public MainWatch(String loc, String ThreadName, List<String> where) {
        location = loc;
        this.threadName = threadName;
        this.where = where;
    }

    ...
    @Override
    public void run() {
        synchronized(where) {
            where.add(location);
        }
    }
}