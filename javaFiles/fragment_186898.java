static class Clicker implements Runnable{
    BigInteger click = BigInteger.ZERO;
    Thread t;

    Clicker(int p){
        t=new Thread(this);
        t.setPriority(p);
    }

    public void run(){
        try {
        latch.await();
        } catch(InterruptedException ie) {}
        while(running)
            click = click.add(BigInteger.ONE);
    }

    public void start(){
        t.start();
    }
}

public static volatile boolean running = true;
public static final CountDownLatch latch = new CountDownLatch(1);

public static void main(String args[]){
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    List<Clicker> listLow = new ArrayList<Clicker>();
    List<Clicker> listHigh = new ArrayList<Clicker>();
    for (int i = 0; i < 16; i++) {
        listHigh.add(new Clicker(Thread.NORM_PRIORITY+4));
    }
    for (int i = 0; i < 16; i++) {
        listLow.add(new Clicker(Thread.NORM_PRIORITY-4));
    }
    for (Clicker clicker: listLow) {
        clicker.start();
    }
    for (Clicker clicker: listHigh) {
        clicker.start();
    }
    latch.countDown();
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {

        e.printStackTrace();
    }
    running = false;

    BigInteger lowTotal = BigInteger.ZERO;
    BigInteger highTotal = BigInteger.ZERO;
    try {
        for (Clicker clicker: listLow) {
            clicker.t.join();
            lowTotal = lowTotal.add(clicker.click);
        }
    for (Clicker clicker: listHigh) {
            clicker.t.join();
            highTotal = highTotal.add(clicker.click);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("LO: "+lowTotal);
    System.out.println("HI: "+highTotal);
 }