import java.text.MessageFormat;

public class StringReveal {

    private final String original;

    private final StringBuilder stringBuilder;
    private String currentString;
    private int missingLetters;

    public StringReveal(String original, char placeholder) {
        if (original.indexOf(placeholder) >= 0) {
            throw new IllegalArgumentException("placeholder must not be contained in the string");
        }

        if (Character.isWhitespace(placeholder)) {
            throw new IllegalArgumentException("placeholder must not be a whitespace character");
        }

        this.original = original;
        this.stringBuilder = new StringBuilder();
        this.missingLetters = original.length();

        for (char c : original.toCharArray()) {
            if (Character.isWhitespace(c)) {
                // keep whitespace characters the same
                missingLetters--;
                stringBuilder.append(c);
            } else {
                // replace everything else with placeholder char
                stringBuilder.append(placeholder);
            }
        }
        this.currentString = stringBuilder.toString();
    }

    public void reveal(char c) {
        int index = original.indexOf(c);
        if (index < 0 || currentString.charAt(index) == c) {
            // if letter was already replaced or does not exist in the original
            // there's nothing to do
            return;
        }

        do {
            // replace char
            stringBuilder.setCharAt(index, c);
            missingLetters--;

            // find next char
            index = original.indexOf(c, index + 1);
        } while (index >= 0);

        currentString = stringBuilder.toString();
    }

    public String getCurrentString() {
        return currentString;
    }

    public int getMissingLetters() {
        return missingLetters;
    }

    public static void main(String[] args) {
        StringReveal stringReveal = new StringReveal("banana bread", '*');

        char[] guesses = {'a', 'x', 't', 'a', 'b', 'k', 'n', 'g', 'd', ' ',  '*', 'r', 'w', 'e'};

        System.out.println("Try to guess this sting: " + stringReveal.getCurrentString());

        for (char guess : guesses) {
            stringReveal.reveal(guess);
            System.out.println(MessageFormat.format("Current String: {0} ; guess: ''{1}''; you still have to guess {2} letters",
                    stringReveal.getCurrentString(),
                    guess,
                    stringReveal.getMissingLetters()));
        }
    }

}