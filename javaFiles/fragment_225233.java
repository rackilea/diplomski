import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeTrial3 {

    public static void main(String... commandLineArguments) {
        Scanner consoleInput = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm:ss");

        String time1String = consoleInput.nextLine();
        LocalTime time1 = LocalTime.parse(time1String, timeFormatter);
        String time2String = consoleInput.nextLine();
        LocalTime time2 = LocalTime.parse(time2String, timeFormatter);
        if (time2.isBefore(time1)) {
            System.err.println("First time must be before or equal to second time, they were"
                    + time1 + " and " + time2);
            System.exit(1);
        }

        String timeToAddString = consoleInput.nextLine();
        LocalTime timetoAdd = LocalTime.parse(timeToAddString, timeFormatter);
        int minutesToAdd = consoleInput.nextInt();
        LocalTime timeToCompare = timetoAdd.plusMinutes(minutesToAdd);
        if (timeToCompare.isBefore(time1))
        {
            System.out.println("1");
        }
        else if (timeToCompare.isBefore(time2))
        {
            System.out.println("2");
        }
        else
        {
            System.out.println("False");
        }
    }

}