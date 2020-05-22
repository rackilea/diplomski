import java.util.Scanner;

public class DayOfYear {

    private static int[] MONTH_LENGTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month;
        int year;
        int day;
        int remainingDays = 0, numDays = 0, totalDays = 365;
        System.out.println("Please enter the Month: ");
        month = input.nextInt();
        System.out.println("Please enter the Year: ");
        year = input.nextInt();
        System.out.println("Please enter the Day: ");
        day = input.nextInt();

        if (isLeapYear(year)) {
            totalDays++;
        }
        for (int iMonth = 1; iMonth < month; iMonth++) {
            numDays += MONTH_LENGTHS[iMonth];
            if (iMonth == 2 && isLeapYear(year)) {
                numDays++;
            }
        }
        numDays += day;

        remainingDays = totalDays - numDays;
        System.out.println("Number of days since start of the year = " + numDays);
        System.out.println("Remaining days of the year = " + remainingDays);

    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year != 2000;
    }
}