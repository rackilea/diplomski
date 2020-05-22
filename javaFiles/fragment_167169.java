public static void main(final String[] args) {
    // Default words to search for
    String queryWordsString = "doctor,frankenstein,the,monster,igor,student,college,lightning,electricity,blood,soul";

    if (args.length > 0) { // If the user provided  query words
        queryWordsString = args[0];
    }

    final String[] queryWords = queryWordsString.split(","); // split the string into an array

    System.out.println("SEARCH AND SORT");
    System.out.println();
    System.out.println("Searching and counting the words " + queryWordsString); // print the words to search for
    System.out.println();

    // Just the name of the file if it's in the same directory of program
    // The absolute path if they are in different directory
    final String filename = "frankenstein.txt";

    // Read words from file
    final String[] words = SearchAndSort.readWords(filename);
    if (words == null) {
        return;
    }

    final int[] wordsCounter = new int[queryWords.length];

    // Store the starting time
    final long startTime = System.currentTimeMillis();

    // Search the words and store their count
    for (int i = 0; i < queryWords.length; i++) {
        final int count = SearchAndSort.countWordsInUnsorted(queryWords[i], words);
        wordsCounter[i] = count;
    }

    final long elapsedTime = System.currentTimeMillis() - startTime;

    System.out.println("NAIVE SEARCH:");
    // Print how many time each word appears
    for (int i = 0; i < queryWords.length; i++) {
        System.out.println(queryWords[i] + ": " + wordsCounter[i]);
    }

    final int totalSearches = queryWords.length * words.length;
    final double timePerSearch = ((double) elapsedTime) / totalSearches;
    // Print the elapsed time in ms
    System.out.println(elapsedTime + " ms for " + totalSearches + " searches, " + timePerSearch + " ms per search");
}