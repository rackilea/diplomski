import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter.setLenient(false);
    Date inputDate;

    while(true){
      System.out.print("Enter a date in the format of MM/dd/yyyy:");
      String date = scanner.nextLine();
      try {
        inputDate = formatter.parse(date);
        break;
      } catch (Exception e) {
        System.err.println("ERROR: Please input the date in the correct format");
      }
    }

    Calendar c = Calendar.getInstance();
    c.setTime(inputDate);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    System.out.println("The day of week is " + days[dayOfWeek - 1]);
  }
}