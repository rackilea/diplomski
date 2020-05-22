class Foo extends Thread {

    CountDownLatch latch;

    public Foo(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public synchronized void start() {

        try {
            sleep(1000);
            latch.countDown(); // in every call latch decrease one, when it    reach to zero, every thread that is waiting the latch will continue.
sleep(100);
        } catch (InterruptedException e) {

        }
    }
}    
class FooBar {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        new Foo(latch).start();

        latch.await(); // wait latch reach to zero. BE CAREFUL, IT'S NOT WAIT(),
                        // IT'S AWAIT()   
        System.out.println("done");
    }
}