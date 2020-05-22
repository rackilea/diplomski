import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        System.out.print("Input a string: ");
        String str = in.nextLine();

        Counts counts = count(str);

        System.out.println("Number of Vowels in the string: " + counts.getVowels());
        System.out.println("Number of Consonants in the string: " + counts.getConsonants());
    }

    public static Counts count(String str) {
        int vowCount = 0;
        int consCount = 0;

        str = str.toLowerCase();

        int i = str.length();
        while(i-- > 0) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                switch(ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowCount++;
                        break;
                    default:
                        consCount++;
                        break;
                }
            }
        }

        return new Counts(vowCount, consCount);
    }

    public static final class Counts {
        private int vowels;
        private int consonants;

        public Counts(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        public int getVowels() {
            return vowels;
        }

        public int getConsonants() {
            return consonants;
        }
    }
}