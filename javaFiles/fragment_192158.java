import org.joda.time.*;
import org.joda.time.format.*;

public class Test
{
    public static void main(String[] args)
    {
        LocalDate today = new LocalDate();
        // Alternatively, use DateTimeFormat.mediumDate etc
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        System.out.println(formatter.print(today));
    }
}