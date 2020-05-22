import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

Period p = Period.parse("P-25Y-11M-16D");
LocalDate d = LocalDate.now();
LocalDate d2 = d.plus(p);
// The following gets the difference in days (or any other ChronoUnit)
System.out.println(d.until(d2, ChronoUnit.DAYS));