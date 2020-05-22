import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class Test {
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(2);
        ex.scheduleAtFixedRate(new Start(),  0 , 24, TimeUnit.HOURS);
        ex.scheduleAtFixedRate(new End(),  2 , 24, TimeUnit.HOURS);
        scanner = new Scanner(System.in);
        while(true){
            if(scanner.hasNext() && "Q".equals(scanner.next())){
                System.exit(0);
            }
            Thread.sleep(10000);
        }
    }
}

class Start implements Runnable{

    @Override
    public void run() {
        //start your game
    }

}

class End implements Runnable{

    @Override
    public void run() {
        //shutdown your game
    }

}