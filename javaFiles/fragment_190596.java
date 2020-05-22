public class MainThread {
    public void run() {
        List<Thread> threads = Arrays.asList(
            new Thread(() -> react(this)),
            new Thread(() -> react(this)),
        );
        // start all threads first to avoid deadlock
        threads.forEach(Thread::start);
        // wait for all threads to finish in order
        threads.forEach(Thread::join);
        // here you can do whatever post steps you want
    }
    public void react(Thread t) {
        System.out.print("MainThread called by " + t);
    }
}