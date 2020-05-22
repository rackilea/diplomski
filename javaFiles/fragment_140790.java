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
        StringBuffer buffer = new StringBuffer();

        for (char ch : expression.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                bufferToItem(buffer, result);
            } else {
                if (Character.isDigit(ch) || ch == '.') {
                    buffer.append(ch);
                } else {
                    bufferToItem(buffer, result);
                    result.add(Character.toString(ch));
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void bufferToItem(StringBuffer buffer, List<String> list) {
        addItemIf(list, buffer);
        clearBuffer(buffer);
    }

    public static void addItemIf(List<String> list, StringBuffer buffer) {
        if (buffer.length() > 0) list.add(buffer.toString());
    }

    public static void clearBuffer(StringBuffer buffer) {
        buffer.delete(0, buffer.length());
    }
}