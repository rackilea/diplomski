import java.util.Random;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class RandomTime {

DateTimeFormatter inputFormat = DateTimeFormat.forPattern("HH:mm:ss yyyy-MM-dd");
DateTimeFormatter outputFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

public TwoRandomTimes getRandomTimesFromSeed(String inputDateTime) {
    DateTime seed = inputFormat.parseDateTime(inputDateTime);
    Random random = new Random();
    int seconds1 = random.nextInt(3600);
    int seconds2 = random.nextInt(3600 - seconds1);

    DateTime time1 = new DateTime(seed).plusSeconds(seconds1);
    DateTime time2 = new DateTime(time1).plusSeconds(seconds2);
    return new TwoRandomTimes(time1, time2);
}

public class TwoRandomTimes {
    public final DateTime random1;
    public final DateTime random2;

    private TwoRandomTimes(DateTime time1, DateTime time2) {
        random1 = time1;
        random2 = time2;
    }

    @Override
    public String toString() {
        return "Random1 - " + outputFormat.print(random1) + "\nRandom2 - " + outputFormat.print(random2);
    }
}

public static void main(String[] args) {
    RandomTime rt = new RandomTime();
    System.out.println(rt.getRandomTimesFromSeed("18:00:00 2013-02-13"));
}
}