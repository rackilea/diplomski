public class DriverClass {

    public static void main(String[] args) throws InterruptedException {
        int upper = 15;
        Integer sumValue = null;
        Summation sum = new Summation(upper, sumValue);

        Thread thread = new Thread(sum);
        thread.start();
        thread.join();

        sumValue = sum.getSumValue();

        System.out.println(sumValue);
    }

}

class Summation implements Runnable {

    private final int upper;
    private Integer sumValue;

    public Summation(int upper, Integer sumValue) {
        this.upper = upper;
        this.sumValue = sumValue;
    }

    @Override
    public void run() {
        System.out.println("Thread started...");
        int sum = 0;
        for (int i = 0; i <= upper; i++) {
            sum += i;
        }
        System.out.println("Sum is:" + sum);
        sumValue = sum;
    }

    public Integer getSumValue() {
        return sumValue;
    }
}