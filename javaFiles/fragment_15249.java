import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.parse("13:00:00").plus(Duration.ofMinutes(144));
        System.out.println(time);
    }
}