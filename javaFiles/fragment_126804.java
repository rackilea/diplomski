public class TestHangMan {

    public static void main(String[] args) {
        new TestHangMan();
    }

    public TestHangMan() {
        String word = "Testing";
        String mask = "_______";

        mask = checkGuess(word, mask, 'a');
        System.out.println(mask);
        mask = checkGuess(word, mask, 't');
        System.out.println(mask);
        mask = checkGuess(word, mask, 'e');
        System.out.println(mask);
        mask = checkGuess(word, mask, 's');
        System.out.println(mask);
        mask = checkGuess(word, mask, 'g');
        System.out.println(mask);
        mask = checkGuess(word, mask, 'n');
        System.out.println(mask);
        mask = checkGuess(word, mask, 'i');
        System.out.println(mask);
    }

    protected String checkGuess(String word, String mask, char guess) {
        guess = Character.toLowerCase(guess);
        StringBuilder sb = new StringBuilder(mask);
        for(int index = 0; index < word.length(); index++) {
            if (Character.toLowerCase(word.charAt(index)) == guess) {
                sb.setCharAt(index, word.charAt(index));
            }
        }
        return sb.toString();
    }

}