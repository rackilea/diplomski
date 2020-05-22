import javax.swing.JOptionPane;

public class zeller {
    public static void main(final String[] args) {

        String yearString = JOptionPane.showInputDialog("Enter the year:");

        int year = Integer.parseInt(yearString);

        String monthString =
            JOptionPane.showInputDialog("Enter the month (3-12)(January and Feburary are 13 and 14):");
        int month = Integer.parseInt(monthString);

        String dayString = JOptionPane.showInputDialog("Enter the day 1-31: ");
        int day = Integer.parseInt(dayString);

        switch (month) {
        case 14:
            year--;
            monthString = "January";
            break;
        case 13:
            year--;
            monthString = "February";
            break;
        case 3:
            monthString = "March";
            break;
        case 4:
            monthString = "April";
            break;
        case 5:
            monthString = "May";
            break;
        case 6:
            monthString = "June";
            break;
        case 7:
            monthString = "July";
            break;
        case 8:
            monthString = "August";
            break;
        case 9:
            monthString = "September";
            break;
        case 10:
            monthString = "October";
            break;
        case 11:
            monthString = "November";
            break;
        case 12:
            monthString = "December";
            break;
        default:
            monthString = "Invalid month";
            break;
        }
        int j = year / 100;
        int k = year % 100;
        double h = (day + ((13 * (month + 1) / 5)) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        int h1 = (int) h;
        switch (h1) {
        case 0:
            dayString = "Saturday";
            break;
        case 1:
            dayString = "Sunday";
            break;
        case 2:
            dayString = "Monday";
            break;
        case 3:
            dayString = "Tuesday";
            break;
        case 4:
            dayString = "Wednesday";
            break;
        case 5:
            dayString = "Thursday";
            break;
        case 6:
            dayString = "Friday";
            break;

        default:
            monthString = "Invalid month";
            break;
        }

        System.out.println("Day of the week is: " + dayString);

    }
}