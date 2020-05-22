public class Count {

    public static void main(String[] args) {
        System.out.print("Please enter a string: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int arr[] = analyze(text);
        System.out.println(arr);
        System.out.println("Total number of words: " + arr[0]);
        System.out.println("Total number of characters: " + arr[1]);
        System.out.println("Total number of newlines: " + arr[2]);

    }

    public static int[] analyze(String text) {
        int[] arr = new int[3];

        // count lines
        String[] lines = text.split("\r\n|\r|\n"); // taken from https://stackoverflow.com/questions/454908/split-java-string-by-new-line
        arr[2] = lines.length;

        // count number of words
        arr[0] = countWords(text);

        // count number of characters
        arr[1] = counteCharacters(text);
        return arr;
    }

    static final int OUT = 0;
    static final int IN = 1;

    static int countWords(String str)  // taken from https://www.geeksforgeeks.org/count-words-in-a-given-string/
    {
        int state = OUT;
        int wc = 0;
        int i = 0;

        while (i < str.length()) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                    || str.charAt(i) == '\t')
                state = OUT;

            else if (state == OUT) {
                state = IN;
                ++wc;
            }
            ++i;
        }
        return wc;
    }

    static int count = 0; // taken from https://www.javatpoint.com/java-program-to-count-the-total-number-of-characters-in-a-string

    static int counteCharacters(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}