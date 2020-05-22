import java.util.*;

public class MathExpressionParser {
    public static void main(String[] args) {
        String[] tokens = parseExpression("(- ( / 8 14) 0.5)");

        for (int i = 0; i < tokens.length; i++) {
            System.out.printf("%2d.  %s%n", i, tokens[i]);
        }
    }

    public static String[] parseExpression(String expression) {
        List<String> result = new ArrayList<String>();
        Scanner scanner = new Scanner(expression);

        scanner.useDelimiter("[ ]+(?<=[-+*/\\(\\) ])|(?=[-+*/\\(\\) ])");

        while (scanner.hasNext()) {
            result.add(scanner.next());
        }
        scanner.close();

        return result.toArray(new String[result.size()]);
    }
}