import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
  public static void main(String[] args) {   
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse("2018-08-31", fmt);
    System.out.println(fmt.format(date.plusDays(1)));

    // yyyy-MM-dd so happens to be the default for LocalDate, so...
    // we can make it a lot simpler:
    date = LocalDate.parse("2018-08-31");
    System.out.println(date.plusDays(1));
  }
}