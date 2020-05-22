class MyTask implements Runnable {

    public volatile int counter;

    MyTask(int n) {
        counter = n;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" entered run");
        go();
        System.out.println(Thread.currentThread().getName()+" finished run");
    }

    synchronized void go() {

        System.out.println(Thread.currentThread().getName()+" entered go");
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
        System.out.println(Thread.currentThread().getName()+" left from go");
    }
}

class Luncher {
    public static void main(String args[]) throws InterruptedException {

        //lets create task we want to execute in parallel
        MyTask task = new MyTask(0);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++)//create thread instances
            threads[i] = new Thread(task);

        for (int i = 0; i < 10; i++)//start threads
            threads[i].start();

        for (int i = 0; i < 10; i++)
            threads[i].join();//hold main thread to wait till all threads will finish
        System.out.println(task.counter);
    }
}