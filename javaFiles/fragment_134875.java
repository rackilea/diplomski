public class Euler14 {
    public static void main(String[] args) {
        int maxTerm = 1000000;
        int maxNumberOfTerms = 1;

        // this loop replaces your recursion, which is not needed here and quite costly even if it is tail-recursion
        for (int i = maxTerm ; i >= 2; i--) {
            int numberOfTerms = 0;
            // declare as long to prevent the overflow
            long currentNumber = i;
            while (currentNumber != 1) {
                if (currentNumber % 2 == 0)
                    currentNumber = currentNumber / 2;
                else
                    currentNumber = (3 * currentNumber) + 1;

                numberOfTerms++;
                if (numberOfTerms > maxNumberOfTerms) {
                    maxNumberOfTerms = numberOfTerms;
                    maxTerm = i;
                }
            }
        }
        System.out.println(maxTerm);
    }
}