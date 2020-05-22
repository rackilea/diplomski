import java.util.*;
import java.lang.*;

class RandomGenerator {
    private static final String alpha = "a";
    private static final String data = alpha;

    // I removed final from here. reusing your string variable for storing values.
    private static String combinationOFA = alpha;

    // Introduced two variable max and min to find out max and min
    // characters you need to generate
    private static final Integer max = 50;
    private static final Integer min = 1;

    public static void main(String[] args) {

        for (int n = 0; n < 50; n++) {
            Random theGeneratorForLength = new Random();

            // you need to call method you created below with proper values.
            // min and max are max and min random values for you
            // and assigned value to combinationOFA
            combinationOFA = generateRandomALetter(theGeneratorForLength.nextInt(max - min) + min);

            // moved this line inside the loop to print
            System.out.println("String " + (n + 1) + " :" + combinationOFA);
        }
    }

    public static String generateRandomALetter(int length) {
        Random theGeneratorAlpha = new Random();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int aLengthVariable =
                    theGeneratorAlpha.nextInt(combinationOFA.length());
            char alphaTeta = combinationOFA.charAt(aLengthVariable);

            sb.append(alphaTeta);
        }
        return sb.toString();
    }
}