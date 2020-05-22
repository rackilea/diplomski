import java.util.regex.Pattern;

public class CountingWords {
    public static void main(String... args) {
        String text = "This is a string. With some punctuation, but I only care about words.";

        int threshold = 5;
        long amountOfWords = Pattern.compile("[.,; ]+")
                .splitAsStream(text)
                .filter( word -> word.length() > threshold)
                .count();

        System.out.println("There are " + amountOfWords +  " words with more than " + threshold + " characters");
    }
}