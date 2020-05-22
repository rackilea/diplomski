import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FindWord {

    public static void main(String[] args) {
        String search = "Doctor Smith went gardening then went to the cinema on Tuesday";
        List<String> words = Arrays.asList("then", "to", "went");

        int index = 0;
        int result = -1;
        String match = null;

        StringTokenizer tokenizer = new StringTokenizer(search, " ", true);

        while(result < 0 && tokenizer.hasMoreElements()) {
            String next = tokenizer.nextToken();

            if(words.contains(next)) {
                result = index;
                match = next;
            } else {
                index += next.length();
            }
        }

        if(match == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("Found '" + match + "' at index: " + result);
        }
    }
}