import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Counting {
    public static void main(String... args) {
        String text = "This is a string. With some punctuation, but I only care about words.";

        String wordsWithLengths = Pattern.compile("[.,; ]+")
                .splitAsStream(text)
                .map(word -> word + " => " + word.length())
                .collect(Collectors.joining("\n"));

        System.out.println(wordsWithLengths);
    }
}