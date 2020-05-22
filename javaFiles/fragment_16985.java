public class Main {

    //Supports only english vowels (uperrcase, or lowercase):
    public static boolean isVowel(final int codePoint) {
        return "aeiouyAEIOUY".indexOf(codePoint) >= 0;
    }

    public static void main(final String[] args) {
        System.out.println(isVowel('A')); //true.
        System.out.println(isVowel('b')); //false.
    }
}