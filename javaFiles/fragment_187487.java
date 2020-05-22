public class TestStringIteration {

    private static final HashSet<Character> VOWELS = new HashSet<Character>(
            Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final HashSet<Character> CONSONANTS = new HashSet<Character>(
            Arrays.asList('b', 'c')); // Add more letters :-)

    void stringTest(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // This is a digit
            } else if (isVowel(c)) {
                // This is a vowel
            } else if(isConsonant(c)) {
                // This is a consonant
            }
        }
    }


    private static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }

    private static boolean isConsonant(char c) {
        return CONSONANTS.contains(c);
    }
}