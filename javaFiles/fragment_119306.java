/* package whatever; // don't place package name! */
package chapter5;

/* Name of the class has to be "Main" only if the class is public. */

public class Assignment2 {
    public static void main(String[] args) {
        //T(°C) = (T(°F) - 32) × 5/9
        final String DEGREE  = "\u00b0";
        int F = -40;        
        float C = 0.0F;

        while (F <= 120 ){

            C = (F - 32)*(0.5556F);

            System.out.printf("%d%sF  \t\t\t%.1f%sC\n", F, DEGREE, C, DEGREE);
            F = F + 5;
        }
    }   
}