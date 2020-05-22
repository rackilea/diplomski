import java.util.*;

public class Test{
    static double Nonce;

    public static void main(String... args) throws Exception{
        final Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                //calcualte hashRate by any formula
                double hashRate = Nonce/100.0;

                //check if the timer needs to continue, else call timer.cancel()

                System.out.println(hashRate);
            }
        }, 0, 500);

        while(true){
            Thread.sleep(100);
            Nonce++;

            if(Nonce == 100){
                timer.cancel(); //or terminate the timer outside the loop
                break;
            }
        }  
    }
}