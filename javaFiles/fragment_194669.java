/**
 * Finds docuiments where all the given words appear.
 * 
 * @param wordTodocumentQueryMap For each word maps file no. to frequency > 0
 * @param firstWord 
 * @param otherWords
 * @return A frequency map containing file no. of files containing all of fisrtWord and otherWords mapped
 *         to a sum of counts for the words.
 */
public static Map<Integer, Integer> docsWithAllWords(Map<String, Map<Integer, Integer>> wordTodocumentQueryMap,
        String firstWord, String... otherWords) {
    // result
    Map<Integer, Integer> fileScore = new TreeMap<>();
    Map<Integer, Integer> firstWordCounts = wordTodocumentQueryMap.get(firstWord);
    if (firstWordCounts == null) { // first word not found in any doc
        // return empty result
        return fileScore;
    }
    outer: for (Map.Entry<Integer, Integer> firstWordCountsEntry : firstWordCounts.entrySet()) {
        Integer docNo = firstWordCountsEntry.getKey();
        int sumOfCounts = firstWordCountsEntry.getValue();
        // find out if both/all other words are in doc, and sum counts
        for (String word : otherWords) {
            Map<Integer, Integer> wordCountEntry = wordTodocumentQueryMap.get(word);
            if (wordCountEntry == null) {
                return fileScore;
            }
            Integer wordCount = wordCountEntry.get(docNo);
            if (wordCount == null) { // word not found in doc
                continue outer;
            }
            sumOfCounts += wordCount;
        }
        fileScore.put(docNo, sumOfCounts);
    }
    return fileScore;
}