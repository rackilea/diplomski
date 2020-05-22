import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String text = "my email is foo@bar.com and my number is (213)-XXX-XXXX";

        List<Token> findings = new ArrayList<>();
        findings.add(new Token(12, 22, "EMAIL_ADDRESS"));
        findings.add(new Token(41, 54, "PHONE_NUMBER"));

        System.out.println(replace(text, findings));
    }

    public static String replace(String text, List<Token> findings) {
        int position = 0;
        StringBuilder result = new StringBuilder();

        for (Token finding : findings) {
            result.append(text.substring(position, finding.start));
            result.append('[').append(finding.type).append(']');

            position = finding.end + 1;
        }

        return result.append(text.substring(position)).toString();
    }
}

class Token {
    int start, end;
    String type;

    Token(int start, int end, String type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }
}