import java.util.*;

public class ValidDate {
    /**
     * @param date
     *            //date to be checked passed as arguement
     * @return z // true or false // returns true if the date is in correct
     *         format else false
     */
    public static boolean check(String date) {
        boolean z = true;
        //no need to use label
        //label: // using labelled break technique
        // Exception handling( process of dealing with erroneous situations
        // during program execution) using try-catch
        try {
            //< 10, not < 9
            for (int i = 0; i < 10; i++) {

                if (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7 || i == 8 || i == 9)// dd-mm-Yyyy
                {
                    if (Character.isDigit(date.charAt(i)) == false) {
                        z = false;
                        break;
                    }
                } else if (i == 2 || i == 5) {
                    if (!(date.charAt(i) == '-')) {
                        z = false;
                        break;
                    }
                }
                //not 8
                if (i == 9) {
                    if ((Integer.parseInt(date.substring(3, 5)) > 12)) {
                        z = false;
                        break;
                    }
                    if ((Integer.parseInt(date.substring(0, 2)) > 31)) {
                        z = false;
                        break;
                    }
                    System.out.println("YEAR:" + (Integer.parseInt(date.substring(6)) + " " + Calendar.getInstance().get(Calendar.YEAR)));
                    if ((Integer.parseInt(date.substring(6)) < Calendar.getInstance().get(Calendar.YEAR))) {
                        z = false;
                        break;
                    }
                    System.out.println("MONTH:" + (Integer.parseInt(date.substring(3, 5)) + " " + (Calendar.getInstance().get(Calendar.MONTH) + 1)));
                    if ((Integer.parseInt(date.substring(3, 5)) < (Calendar.getInstance().get(Calendar.MONTH) + 1))) {
                        z = false;
                        break;
                    }
                    System.out.println("DATE:" + (Integer.parseInt(date.substring(0, 2)) + " " + Calendar.getInstance().get(Calendar.DATE)));
                    if ((Integer.parseInt(date.substring(0, 2)) < Calendar.getInstance().get(Calendar.DATE))) {
                        z = false;
                        break;
                    }

                }
            }
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(check("02-05-2016"));
    }
}