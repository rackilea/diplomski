package utils;

import java.text.DecimalFormat;

public class Utils {
    public final static double FIXED_SALARY = 30000;

    /**
     * Formats the given decimal number.
     * @param dec The number to format
     * @return The formatted number as string.
     */
    public static String numFormat(double dec) {
        return new DecimalFormat("##,##0.00").format(dec);
    }

    /**
     * Calculates the salary based on the given sales.
     * @param sales The annual sales
     * @return The calculated salary.
     */
    public static double calculateSalary(double sales) {
        double commissionRate = 0.10d;

        if (sales < 320000) {
            commissionRate = 0.00d;
        } else if (sales >= 320000 && sales < 400000) {
            commissionRate = 0.08d;
        }

        // System.out.println("The current commission is " + (int)(commissionRate * 100) + "% of total sales.");

        return FIXED_SALARY + (sales * commissionRate);
    }
}