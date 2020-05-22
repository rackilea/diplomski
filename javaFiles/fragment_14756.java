public class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting process id: " + id);
        int currentPrimeNo = Utils.generateNextPrime();
        System.out.println("Prime Number Associated with this thread " + id +" is: " + currentPrimeNo);
        System.out.println("Completed process id: " + id);
    }

}

public class Utils {

    private static volatile int currentPrime = 0;
    public static synchronized int generateNextPrime(){
        currentPrime++;
        if(currentPrime < 2){
            currentPrime = 2;
            return currentPrime;
        }
        for (int i = 2; i <currentPrime; i++) {
            if(currentPrime%i == 0) {
                currentPrime++;
                i=2;
            } else{
                continue;
            }
        }
        return currentPrime;
    }
}