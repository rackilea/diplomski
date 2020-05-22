import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class HexToDecimal {

    public static BigInteger hexToDecimal(String hexInput) throws IOException {
        BigInteger decimal = BigInteger.ZERO;
        int len = hexInput.length();

        for (int i = len - 1; i >= 0; i--) {
            char c = hexInput.charAt(len - i - 1);
            BigInteger cValue;

            switch (c) {
            case '1':
                cValue = BigInteger.ONE;
                break;
            case '2':
                cValue = BigInteger.valueOf(2l);
                break;
            case '3':
                cValue = BigInteger.valueOf(3l);
                break;
            case '4':
                cValue = BigInteger.valueOf(4l);
                break;
            case '5':
                cValue = BigInteger.valueOf(5l);
                break;
            case '6':
                cValue = BigInteger.valueOf(6l);
                break;
            case '7':
                cValue = BigInteger.valueOf(7l);
                break;
            case '8':
                cValue = BigInteger.valueOf(8l);
                break;
            case '9':
                cValue = BigInteger.valueOf(9l);
                break;
            case 'A':
                cValue = BigInteger.valueOf(10l);
                break;
            case 'B':
                cValue = BigInteger.valueOf(11l);
                break;
            case 'C':
                cValue = BigInteger.valueOf(12l);
                break;
            case 'D':
                cValue = BigInteger.valueOf(13l);
                break;
            case 'E':
                cValue = BigInteger.valueOf(14l);
                break;
            case 'F':
                cValue = BigInteger.valueOf(15l);
                break;
            default: // unexpected character
                throw new IllegalArgumentException("Non-hex character " + c
                        + " found at position " + i);
            }
            decimal = decimal.add(cValue
                    .multiply(BigInteger.valueOf(16).pow(i)));
        }
        return decimal;

    }

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("results.txt");
        BufferedReader br = new BufferedReader(in);

        String line;
        while ((line = br.readLine()) != null) {
            String[] hexNums = line.split(" ");
            for (String hex : hexNums)
                out.printf(hexToDecimal(hex) + "\n");
        }
        in.close();

    }

}