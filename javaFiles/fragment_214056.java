import java.text.DecimalFormat;
import java.util.Scanner;

public class TwoDimArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1) Declare and allocate Storage
        //Each day name is assigned to the array as a String so each name must be enclosed in apostrophes and each string must be separated by commas.
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double[][] Temperature = new double[4][7];

        // 2) Populate Array
        for (int i = 0; i < Temperature.length; i++) {
            for (int j = 0; j < Temperature[0].length; j++) {
                //days[j] will print the proper day and "(i+1)" will print the proper day of the week
                System.out.print("Enter " + days[j] + " Temperature " + "for Week " + (i + 1) + ": " + "    ");
                Temperature[i][j] = scan.nextDouble();
            }

        }
        System.out.println();
        System.out.println("              Weekly Temperature Report ");
        System.out.println("Mon     Tue     Wed     Thurs    Fri    Sat     Sun    Average");

        double columnTotal, average[] = new double[Temperature.length];
        // 4) Output Array

        for (int i = 0; i < Temperature.length; i++) {
            System.out.println();
            columnTotal = 0;
            for (int j = 0; j < Temperature[0].length; j++) {
                System.out.print(Temperature[i][j] + "\t");
                columnTotal += Temperature[i][j];
            }
            average[i] = columnTotal / 7;
            System.out.println(average[i]);
        }

        System.out.println();
        System.out.println("------------------------------------------------------------------");

        columnTotal = 0;
        for (int i = 0; i < average.length; i++) {
                columnTotal = columnTotal +average[i];
            }
            System.out.print((columnTotal / 4) + "    ");
            //System.out.print(average/4);

        }
    }