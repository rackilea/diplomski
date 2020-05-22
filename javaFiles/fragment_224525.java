public class PrimeRunnable implements Runnable {    
    private int from;
    private List results;   // shared but thread-safe

    public PrimeRunnable(int from, List results) {
        this.from = from;
        this.results = results;
    }

    public void isPrime(int number) {
        for(int i = 2;i < from;i++) {
                if((number % i) == 0) {
                        return;
                }
        }
        // found prime, add to shared results
        this.results.add(number);
    }

    public void run() {
        isPrime(from);      // don't increment, just check one number
    }    
}