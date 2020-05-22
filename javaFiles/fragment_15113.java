import java.util.Arrays;

public class WellFormed {

    public static int maxDigit;

    public void findNumbers(int[] digits, int start, int currPos) {
        if (currPos >= digits.length) {
            System.out.println(Arrays.toString(digits));
            return;
        }

        int maxDigitInCurrPos = maxDigit - digits.length + currPos + 1;
        for (int i = start; i <= maxDigitInCurrPos; i++) {
            digits[currPos] = i;
            findNumbers(digits, i+1, currPos + 1);
        }
    }

    public static void main(String[] args)
    {   
        WellFormed obj = new WellFormed();
        maxDigit = 5;
        int inputSize = 3;
        int[] digits = new int[inputSize];
        obj.findNumbers(digits, 1, 0);
    }
}