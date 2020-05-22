import java.util.regex.Pattern;

public class Regexer {

    public static void main(String[] args) {
        int maxCharacters = 100;
        String data = "Ă ă Â â Î î Ș ș Ț ț";
        String pattern = "^[\\p{L}0-9+,. '-]{1," + maxCharacters + "}$";

        Pattern p = Pattern.compile(pattern);

        if (p.matcher(data).matches()) {
            System.out.println("Hit");
        } else {
            System.out.println("No");
        }

    }
}