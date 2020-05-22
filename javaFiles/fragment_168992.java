import org.joda.time.*;

public class Test {    
    public static void main(String args[]) {
        LocalTime start = new LocalTime(5, 0);
        LocalTime end = new LocalTime(15, 20);
        Period period = new Period(start, end, PeriodType.time());
        System.out.println(period.getHours()); // 10
        System.out.println(period.getMinutes()); // 20        
    }
}