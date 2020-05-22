public static String[] dictionary(String filename) throws FileNotFoundException {
    final String fileName = "dictionary.txt";
    int dictionaryLength = 0, i = 0;

    try (Scanner dictionary = new Scanner(new File(fileName))) {
        while (dictionary.hasNextLine()) {
            ++dictionaryLength;
            dictionary.nextLine();
        }
    }
    String[] theWords = new String[dictionaryLength];
    try (Scanner dictionary = new Scanner(new File(fileName))) {
        while (dictionary.hasNextLine()) {
            theWords[i] = dictionary.nextLine();
            i++;
        }
    }
    return theWords;
}