public static void main(String[] args) throws FileNotFoundException, IOException {

    String[] keywords = {"red", "blue", "yellow", "green"};
    // for easier querying contents of array
    List keywordList = Arrays.asList(keywords);

    System.out.println("This program will count the occurrences of the specific words from a text file.");
    System.out.println("\nThe words to be counted are: " + keywordList + ".\n");

    Map<String, Integer> wordMap = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader("/path/to/file/colours.txt"))) {
        // read a line
        String line = br.readLine();

        while (line != null) {
            // keeping this counts all words separated by whitespace, removing it counts words in my array instead
            // of the file, so I'll get red: 1, blue: 1, yellow: 1 etc.,
            String[] words = line.split(" ");

            for(String oneWord : words ){
                if( keywordList.contains(oneWord)){
                    // thanks @ shmosel for the improvement suggested in comments
                    wordMap.merge(oneWord, 1, Integer::sum);
                }
            }

            line = br.readLine();
        }
    }

    Map<String, Integer> sorted = new TreeMap<>(wordMap);

    for (Object key : sorted.keySet()) {
        System.out.println(key + ": " + wordMap.get(key));
    }
}