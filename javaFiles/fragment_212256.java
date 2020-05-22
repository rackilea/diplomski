import java.time.*;
import java.time.format.*;

class Test {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        String last = "";
        while (true) {
            String next = formatter.format(ZonedDateTime.now());
            if (!last.equals(next)) {
                last = next;
                System.out.println(next);
            }
        }
    }
}