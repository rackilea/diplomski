import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


public class StackoverflowDemo {

    public static void main(String[] args) {
        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println(odt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
}