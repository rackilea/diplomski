public class Blofeld extends Thread {

    private volatile boolean isBombDefused;
    private volatile int count = 10;

    public void run() {
        System.out.println("Blofeld starts countdown");
        while (!isBombDefused) {
            System.out.println(count + " seconds and counting...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            if (count <= 0) {
                System.out.println("This is the price of failure...");
                throw new RuntimeException("BOOOOM!");
            }
        }
        System.out.println("Mr. Bond! Mr. Bond! We can do a deal!");
    }

    public int getCount() {
        return count;
    }

    public void cutRedWire() {
        System.out.println("SNIP!");
        isBombDefused = true;
    }
}

public class Bond {    
    public static void main(String[] args) throws InterruptedException {
        Blofeld blofeld = new Blofeld();
        blofeld.start();
        while (blofeld.getCount() > 007) {
            Thread.sleep(1000);
            System.out.println("Bond works frantically");
        }
        blofeld.cutRedWire();
    }
}