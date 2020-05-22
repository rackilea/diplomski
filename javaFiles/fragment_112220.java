private static final Set<String> lowerCaseWords = new HashSet<String>();
static {
    final Scanner inputFile = new Scanner(new File("common_words.txt"));
    while (inputFile.hasNextLine()) { 
        lowerCaseWords.add(inputFile.nextLine().toLowerCase());
    }
    inputFile.close();
}