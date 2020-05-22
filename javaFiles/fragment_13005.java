int maxLength = 0; 
int indexOfLongestMatch = -1;
for (int i = 0; i < stringList.size(); i++) {                  // Iterate the List
    String string =  stringList.get(i);
    int maxIndex = Math.min(wordA.length(), string.length());  // Compare lengths
    if (maxIndex >= maxLength) {                               // Worth to continue?
        int commonLength = 0;
        for (int j = 0; j < maxIndex; j++) {                   // Iterate characters
            if (string.charAt(j) == wordA.charAt(j)) {
                commonLength++;                                // Any match counts
                if (commonLength >= maxLength) {               // Check for the new max
                    maxLength = commonLength;                  // Register it
                    indexOfLongestMatch = i;                   // New index of the max
                }
            }
        }
    }
}