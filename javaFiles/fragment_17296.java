import java.util.Scanner;

public class ParseDate {

    public static void main(String args[]) {

        String day = null;
        String month = null;
        String year = null;
        String format = null;
        Scanner input = new Scanner(System.in);

        do {
            if (day == null) {
                System.out.println("Enter the day: ");
                day = input.nextLine();
            }
            if (month == null) {
                System.out.println("Enter the month: ");
                month = input.nextLine();
            }
            if (year == null) {
                System.out.println("Enter the year: ");
                year = input.nextLine();
            }

            try {
                format = formatDate(month, day, year);
            } catch (MonthException m) {
                System.err.println(month + " is not a valid month");
                month = null;
            } catch (DayException d) {
                System.err.println(day + " is not a valid day");
                day = null;
            } catch (YearException y) {
                System.err.println(year + " is not a valid year");
                year = null;
            }
        } while (format == null);
    }

    public static String formatDate(String month, String day, String year)
                    throws MonthException, DayException, YearException {
        String output = "Happy";

        int monthNum = 0;
        int dayNum = 0;
        int yearNum = 0;

        try {
            monthNum = Integer.parseInt(month);
            if (monthNum < 1 || monthNum > 12) {
                throw new MonthException("Invalid month. reenter.");
            }
        } catch (NumberFormatException exp) {
            throw new MonthException("Invalid month. reenter.");
        }
        try {
            yearNum = Integer.parseInt(year);
            if (yearNum < 1000 || yearNum > 3000) {
                throw new YearException("Invalid year. reenter.");
            }
        } catch (NumberFormatException exp) {
            throw new YearException("Invalid year. reenter.");
        }
        try {
            dayNum = Integer.parseInt(day);
            // You need to take into consideration the actual month,
            // but I'll leave that to you...
            if (dayNum < 1 || dayNum > 31) {
                throw new DayException("Invalid day. reenter.");
            }
        } catch (NumberFormatException exp) {
            throw new DayException("Invalid day. reenter.");
        }

        //other code here for converting date
        return output;
    }

    public static class MonthException extends Exception {

        public MonthException(String message) {
            super(message);
        }

    }

    public static class DayException extends Exception {

        public DayException(String message) {
            super(message);
        }

    }

    public static class YearException extends Exception {

        public YearException(String message) {
            super(message);
        }

    }
}