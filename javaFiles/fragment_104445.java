import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String R = in.nextLine();
        System.out.println("Converted to Decimal: " + RomanToDecimal(R));
    }

    static int RomanToDecimal(String R) {
        int Decimal = 0;
        char Previous = 0;

        for (int x = 0; x < R.length(); x++) {
            if (R.charAt(x) == 'I')
                Decimal += 1;

            if (R.charAt(x) == 'V') {
                System.out.println(Previous);
                if (Previous == 'I') {
                    Decimal -= 2;
                }
                Decimal += 5;
            }

            if (R.charAt(x) == 'X') {
                if (Previous == 'I') {
                    Decimal -= 2;
                }
                Decimal += 10;
            }

            if (R.charAt(x) == 'L') {
                if (Previous == 'X') {
                    Decimal -= 20;
                }
                Decimal += 50;
            }

            if (R.charAt(x) == 'C') {
                if (Previous == 'X') {
                    Decimal -= 20;
                }
                Decimal += 100;
            }

            if (R.charAt(x) == 'D') {
                if (Previous == 'C') {
                    Decimal -= 200;
                }
                Decimal += 500;
            }

            if (R.charAt(x) == 'M') {
                if (Previous == 'C') {
                    Decimal -= 200;
                }
                Decimal += 1000;
            }
            Previous = R.charAt(x);
        }
        return Decimal;

    }
}