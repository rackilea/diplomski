import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author JKetelaar
 */

public class PriceGrabber implements Runnable {

    private Coinbase coinbase;
    private Variables variables;

    public PriceGrabber(){
        this.coinbase = new Coinbase(0);
        this.variables = new Variables();

        this.variables.connect();
    }

    public static void main(String[] args){
        ScheduledExecutorService scheduleTaskExecutor = Executors.newScheduledThreadPool(5);

        scheduleTaskExecutor.scheduleAtFixedRate(new PriceGrabber(), 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        try {
            if (coinbase.getPrice() == variables.getCoinbase()) {
                System.out.println("No changes found for Coinbase...");
            } else {
                System.out.println("Price Change detected in Coinbase!");

                Double cbase = variables.getCoinbase();
                Double cprice = coinbase.getPrice();

                System.out.println("Old price: " + cprice + "\nNew price: " + cbase + "\nPrice Change: " + (cbase - cprice));
                coinbase.setPrice(cbase);
                variables.addPrice(cbase, "Coinbase", (cprice - cprice));

            }
        } catch (IOException ignored) {

        }

    }


}