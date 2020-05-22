import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BusRandom {

public static void main(String[] args) {
    new BusRandom().test();
}

public void test() {
    long max = 0;
    double average = 0;
    long min = Long.MAX_VALUE;
    int totalBuses=5;//change accordinly
    List<Long> randomList = new ArrayList<>();
    long duration = 2;
    try {
        for (int i = 0; i <totalBuses; i++) {
            System.out.println("Bus Needs Cleaning" + "\n");
            Thread.sleep(1000);
            System.out.println("Bus getting cleaned");
            Thread.sleep(1000);
            duration = (long) (Math.random() * 20);
            randomList.add(duration);
            TimeUnit.SECONDS.sleep(duration);
            System.out.println("Cleaner completed cleaning in" + duration + "Seconds");
            System.out.println("Bus Leaves");
            max=max>duration?max:duration;
            min=min<duration?min:duration;
        }
    } catch (InterruptedException iex) {
    }
    double sum=0;
    for(long l:randomList){
        sum+=l;
    }
    average=(double) (sum/randomList.size());
    System.out.println("Average Waiting Time: " + average + " | Maximum: " + max + " | Minimum" + min + "\n");

}
}