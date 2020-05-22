public class LetterTypeCount 
{
    public static void main(String[] args) {
        // create HashMap to store String keys and Integer values
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap); // create map based on user input
        displayMap(myMap); // display map content
    }

    // create map from user input
    private static void createMap(Map<String, Integer> map)
    {
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Enter a string:"); // prompt for user input
        String input = scanner.nextLine();

        // split to words
        String[] words = input.split(" ");
        for (String word : words) 
        {
            word = word.toLowerCase(); // get lowercase word
            for(int i=0; i<word.length(); i++) 
            {
                char c = word.charAt(i); //get char at position i
                if (map.containsKey(c + "")) // is letter in map
                {
                    int count = map.get(c + ""); // get current count
                    map.put(c + "", count + 1); // increment count
                }
                else
                    map.put(c + "", 1); // add new letter with a count of 1 to map
            }
            // if the map contains the letter
        }
    }

    // display map content
    private static void displayMap(Map<String, Integer> map)
    {
        Set<String> keys = map.keySet(); // get keys

        // sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        // generate output for each key in map
        for (String key : sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));
        System.out.printf("%nsize: %d%nisEmpty: %b%n",
                map.size(), map.isEmpty());
    }
} // end class LetterTypeCount