class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": Running run");
            }
        });
        System.out.println(Thread.currentThread().getName() + ": Running main");
        System.out.println(Thread.currentThread().getName() + ": Calling t.start()");
        t.start();
        System.out.println(Thread.currentThread().getName() + ": Calling t.join() to wait for thread exit");
        try {
            t.join();
        } catch (InterruptedException ie) {
            System.out.println(Thread.currentThread().getName() + ": Calling got InterruptedException");
        }
        System.out.println(Thread.currentThread().getName() + ": Program complete");
    }
}