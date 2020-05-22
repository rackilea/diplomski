import java.util.Arrays;

public class Tokenizer {
    public static String[] tokenize(String expression) {
        String[] tokens = expression.split("(?<=[-+*/\\(\\) ])|(?=[-+*/\\(\\) ])");
        String[] result = new String[tokens.length];
        int i = 0;

        for (String token : tokens) {
            if (!token.equals(" ")) {
                result[i++] = token;
            }
        }

        return Arrays.copyOf(result, i);
    }

    public static void main(String[] args) {
        String[] tokens = tokenize("(- ( / 8 14) 0.5)");

        for (int i = 0; i < tokens.length; i++) {
            System.out.printf("%2d.  %s%n", i, tokens[i]);
        }
    }
}