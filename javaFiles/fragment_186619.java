import java.util.Scanner;

public class BarGraph {

    public static void main(String[] args) {

        Scanner myScanner;
        myScanner = new Scanner(System.in);

        double mon, tues, wed, thurs, fri, sat, sun;

        do {
            try {
                System.out.print("Expenses for Monday: ");
                mon = myScanner.nextDouble();
            } catch (Exception e) {
                mon = -1;
                myScanner.nextLine();
            }
        } while (mon < 0);

        System.out.println(mon);
    }
}