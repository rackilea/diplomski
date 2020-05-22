import java.util.Scanner;

public class main_class {

    public static int num_wrong = 0;
    public static java.io.File file = new java.io.File("text.txt");
    public static String[] valid_letters = new String[130];
    public static boolean wrong = true;
    public static String[] sample = new String[190];

    public static void main (String [] args) {
        try {
            text_file();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void text_file() throws Exception {
        // Create Scanner to read file    
        Scanner input = new Scanner(file);

        String [] valid_letters = { "I", " have ", " got ", "a", "date", "at",
                "quarter", "to", "eight", "8", "7:45", "I’ll", "see", "you",
                "the", "gate", ",", "so", "don’t", "be", "late", "We",
                "surely", "shall", "sun", "shine", "soon", "would", "like",
                "sit", "here", "cannot", "hear", "because", "of", "wood",
                "band", "played", "its", "songs", "banned", "glamorous",
                "night", "sketched", "a", "drone", "flying", "freaked", "out",
                "when", "saw", "squirrel", "swimming", "man", "had", "cat",
                " that", "was", "eating", "bug", "After", "dog", "got", "wet",
                "Ed", "buy", "new", "pet", "My", "mom", "always", "tells",
                "me", "beautiful", "eyes", "first", "went", "school", "wanted",
                "die" };

        while (input.hasNext()) {
            // NOTE: split using space, i.e. " "
            String[] sample = input.next().split(" ");

            // NOTE: j < sample.length
            for (int j = 0; j < sample.length; j++) 
            {
                for (int i = 0; i < valid_letters.length; i++) 
                {
                    // NOTE: string comparison is using equals
                    if (sample[j].equals(valid_letters[i])) {

                        // NOTE: You want to update the variable wrong.
                        // And not create a local variable 'wrong' here!
                        wrong = false;
                        System.out.printf("%-12s is inside!%n",
                                "'" + valid_letters[i] + "'");
                        break;
                    }
                }
                if (wrong) {
                    num_wrong++;
                }
                // Reset wrong
                wrong = true;
            }
        }

        // Print out the results from the search
        System.out.println("The number of wrong words in the first 13 sentences are "
                + num_wrong);
        // Close the file
        input.close();
    }
}