import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.LinkedList;

public class Prime {

    private static final BigInteger THOUSAND = new BigInteger("1000");

    public static void main(String[] args) throws Exception {
        BigInteger number = new BigInteger("2")
                .pow(74/*207281*/) // use 74207281 for the real number
                .subtract(new BigInteger("1"));

        System.out.println("calculation done, creating texts");

        int counter = 0;

        LinkedList<String> threes = new LinkedList<>();

        for (;;) {

            // divide by 1000 to get next 3 digits
            BigInteger[] divideAndRemainder = number.divideAndRemainder(THOUSAND);
            number = divideAndRemainder[0];
            BigInteger lastThreeDigits = divideAndRemainder[1];

            // format digits, with leading zeros
            String text = String.format("%03d", lastThreeDigits);

            // add them to the list
            threes.addFirst(text);

            // stop, if we reached the end
            if (number.signum() == 0) {
                break;
            }

            // print progress
            if (counter++ > 999) {
                System.out.print(".");
                counter = 0;
            }
        }

        System.out.println("\ntexts ready, writing to file");

        counter = 0;
        try (FileOutputStream output = new FileOutputStream(new File("C:\\temp\\bignumber.txt"))) {
            for (String text : threes) {
                output.write(text.getBytes());
                output.write(' ');

                // print progress
                if (counter++ > 999) {
                    output.write('\n');
                    System.out.print(".");
                    counter = 0;
                }
            }
        }

        System.out.println("\ndone");
    }

}