/**
 * Produce a List<String> which contains every combination which can be
 * made by taking one String from each inner String array within the
 * provided two-dimensional String array.
 * @param twoDimStringArray a two-dimensional String array which contains
 * String arrays of variable length.
 * @return a List which contains every String which can be formed by taking
 * one String from each String array within the specified two-dimensional
 * array.
 */
public static List<String> combinations(String[][] twoDimStringArray) {
    // keep track of the size of each inner String array
    int sizeArray[] = new int[twoDimStringArray.length];

    // keep track of the index of each inner String array which will be used
    // to make the next combination
    int counterArray[] = new int[twoDimStringArray.length];

    // Discover the size of each inner array and populate sizeArray.
    // Also calculate the total number of combinations possible using the
    // inner String array sizes.
    int totalCombinationCount = 1;
    for(int i = 0; i < twoDimStringArray.length; ++i) {
        sizeArray[i] = twoDimStringArray[i].length;
        totalCombinationCount *= twoDimStringArray[i].length;
    }

    // Store the combinations in a List of String objects
    List<String> combinationList = new ArrayList<String>(totalCombinationCount);

    StringBuilder sb;  // more efficient than String for concatenation

    for (int countdown = totalCombinationCount; countdown > 0; --countdown) {
        // Run through the inner arrays, grabbing the member from the index
        // specified by the counterArray for each inner array, and build a
        // combination string.
        sb = new StringBuilder();
        for(int i = 0; i < twoDimStringArray.length; ++i) {
            sb.append(twoDimStringArray[i][counterArray[i]]);
        }
        combinationList.add(sb.toString());  // add new combination to list

        // Now we need to increment the counterArray so that the next
        // combination is taken on the next iteration of this loop.
        for(int incIndex = twoDimStringArray.length - 1; incIndex >= 0; --incIndex) {
            if(counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                ++counterArray[incIndex];
                // None of the indices of higher significance need to be
                // incremented, so jump out of this for loop at this point.
                break;
            }
            // The index at this position is at its max value, so zero it
            // and continue this loop to increment the index which is more
            // significant than this one.
            counterArray[incIndex] = 0;
        }
    }
    return combinationList;
}