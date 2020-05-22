import java.util.Scanner;

public class upp {
  public static void main(String[] args) {

    int[] numberOfDaysEachMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    System.out.println("Enter month > ");
    Scanner scanner = new Scanner(System.in);
    int userInputMonth = Integer.parseInt(scanner.next());
    if (userInputMonth > 0 && userInputMonth < 13) {
      System.out.println("Enter the day of month > ");

      int userInputDay = Integer.parseInt(scanner.next());
      if (userInputDay > 0 && userInputDay <= numberOfDaysEachMonth[userInputMonth - 1]) {
        System.out.println("Correct date.");
      } else {
        System.out.println("Wrong date.");
      }
    } else {
      System.out.println("Wrong month.");
    }
  }
}