public class HDtest5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) { // have created infinite loop
            System.out.print("Enter a sentence: ");
            String sentence = in.nextLine();
            System.out.print("Your sentence has " + countWords(sentence) + " words.");

            if (sentence.equals("quit")) { // if enterd value is "quit" than it comes out of loop
                break;
            } else {
                String[] words = sentence.split(" "); // get the individual words
                System.out.println("#words = " + words.length);
                for (int i = 0; i < words.length; i++)
                    System.out.println(sentence + "word[" + i + words[i] + " nchars = " + words[i].length());

            }
            System.out.println(sentence); // to Print string
            System.out.println(sentence.length()); // to print Entered string's length

        }
        in.close();
    }

    private static int countWords(String str) {
        String words[] = str.split(" ");
        int count = words.length;
        return count;
    }
}