public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in); // user input
        String line = stdIn.nextLine(); // read line
        String[] words = line.split("[^a-zA-Z]+"); // split by all non-alphabetic characters (a regex)
        for (String word : words) { // iterate through the words
            System.out.println(word); // print word with a newline
        }
    }
}