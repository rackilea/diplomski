public class LetterCounter {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/para1.txt"));

       int[] count = new int[26];

        while (input.hasNextLine()) {
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            char[] characters = answer.toCharArray();
            /// change here!
            for (int i = 0; i< characters.length ; i++) {
                if((characters[i] >='a') && (characters[i]<='z')) {
                     count[characters[i] -'a' ]++;
                }
            }
            /// change ends.
        }

        for (int i = 0; i < 26; i++) {
            StdOut.print((char) (i + 'a'));
            StdOut.println(": " + count[i]);
        }
    }
}