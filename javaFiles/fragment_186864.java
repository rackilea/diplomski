import static java.lang.System.out;
import java.time.LocalDate;

public class Sample {
    public static void main( String [] args ) {
        LocalDate aMonthAgo = LocalDate.now().minusMonths(1);
        out.println( LocalDate.parse("2009-12-16").isBefore(aMonthAgo));
        out.println( LocalDate.now().isBefore(aMonthAgo));
        out.println( LocalDate.parse("2017-12-24").isBefore(aMonthAgo));
    }
}