import java.util.Scanner;

public class DoubleEchoLine {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String line1 = myScanner.nextLine();
        String line2 = myScanner.nextLine();

        System.out.println(line2);
        System.out.println(line1);
    }

}