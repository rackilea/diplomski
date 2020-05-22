import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SO28210525 {
    private static final Pattern re = Pattern.compile("\\G(?:[^<>{}]++|<(?<pointy>[^<>]++)>|\\{(?<curly>[^{}]++)\\})");

    public static void main(String[] args) {
        String input = "first option<option 1/option 2/option 3>second option<option 5/option 6/option 7>selection{aaaaa/bbbbb/ccccc}{eeeeee/fffff/ggggg}other string";
        Matcher matcher = re.matcher(input);

        ArrayList<String> tokens = new ArrayList<String>();
        ArrayList<String> curly = new ArrayList<String>();
        ArrayList<String> pointy = new ArrayList<String>();

        int lastIndex = 0;

        while (matcher.find()) {
            tokens.add(matcher.group(0));

            String inCurly = matcher.group("curly");
            if (inCurly != null) {
                curly.add(inCurly);
            }

            String inPointy = matcher.group("pointy");
            if (inPointy != null) {
                pointy.add(inPointy);
            }

            lastIndex = matcher.end(0);
        }

        if (lastIndex != input.length()) {
            System.err.println("Invalid input");
        } else {

            System.out.println(tokens);
            System.out.println(curly);
            System.out.println(pointy);
        }
    }

}