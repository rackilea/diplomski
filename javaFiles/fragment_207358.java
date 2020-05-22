public class B implements Callable<BufferedImage> {
    private boolean c;

    public B (boolean c) { this.c = c; }

    public BufferedImage call() {
        //Some operations
        if (!c)
            return null;
        return new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    }
}

// Somewhere, e.g. in your A.compute() method

ExecutorService exe = Executors.newFixedThreadPool(2); // Two threads in parallel
B b = new B(true);
Future<BufferedImage> res = exe.submit(b); // Will return immediately. Processing will run in a thread of 'exe' executor
// ... do things
System.out.println("Finished: "+res.isDone());
BufferedImage img = res.get(); // Will block until image is available (i.e. b.call() returns)