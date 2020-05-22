import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate inputDate;

    while(true){
      System.out.print("Enter a date in the format of MM/dd/yyyy:");
      String date = scanner.next();
      try {
        inputDate = LocalDate.parse(date, formatter);
        break;
      } catch (Exception e) {
        System.err.println("ERROR: Please input the date in the correct format");
      }
    }

    System.out.println("The day of week is " + inputDate.getDayOfWeek().name());
  }
}