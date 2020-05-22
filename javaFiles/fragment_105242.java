class Print2 {

    private static int count = 1;
    private static int MAX = 10;
    private Object obj = new Object();

    public void printEven() {
        while (true) {
            if (count > MAX) break;
            synchronized (obj) {
                System.err.println(Thread.currentThread().getName() + " : " + count++);
                obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) { }
            }
        }
    }

    public void printOdd() {
        while (true) {
            if (count > MAX) break;
            synchronized (obj) {
                System.err.println(Thread.currentThread().getName() + " : " + count++);
                obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) { }
            }
        }
    }

}