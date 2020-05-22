public class Summing implements Runnable {

    int a;

    public Summing(int a) {
        this.a = a;
    }

    public void run() {
        addRondom();
    }

    public void addRondom() {
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        System.out.println("number generated: " + n);
        synchronized (this) {
            a += n;
        }
    }
}