public class IndexOfWordSample {
    public static void main(String[] args) {
        String input = "There are longer strings than this not very long one.";
        String search = "long";
        int index = indexOfWord(input, search);

        if (index > -1) {
            System.out.println("Hit for \"" + search + "\" at position " + index + ".");
        } else {
            System.out.println("No hit for \"" + search + "\".");
        }
    }

    public static int indexOfWord(String input, String word) {
        String nonWord = "^\\W?$", before, after;               
        int index, before_i, after_i = 0;

        while (true) {
            index = input.indexOf(word, after_i);
            if (index == -1 || word.isEmpty()) break;

            before_i = index - 1;
            after_i = index + word.length();
            before = "" + (before_i > -1 ? input.charAt(before_i) : "");            
            after = "" + (after_i < input.length() ? input.charAt(after_i) : "");

            if (before.matches(nonWord) && after.matches(nonWord)) {
                return index;
            }
        }
        return -1;
    }
}