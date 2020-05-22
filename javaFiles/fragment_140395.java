public static double lengthPercentage(int requiredLength) throws FileNotFoundException
    int allWords = 0;
    int requiredWords = 0;
    while(keyboard.hasNext())
    {
        String word = keyboard.next();
        int length = word.length();
        if (length == requiredLength) {
            ++requiredWords;
        }
        ++allWords;
    }
    // implicit assumption: there's at least on word in the file
    return ((double) requiredWords) / allWords;
}