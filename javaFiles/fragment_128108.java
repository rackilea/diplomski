public static int totalFrequencyOfWord(String word) {
    return entries.values()
                   .stream()
                   .filter(i -> word.equals(i.getWord()))
                   .mapToInt(IndexEntry::getFrequency)
                   .sum();
}

/**
 * This method iterates through the values of the {@link TreeMultimap},
 * searching for {@link IndexEntry} objects which have their {@code word}
 * field equal to the parameter, word.
 *
 * @param word
 *     The word to search for in every document.
 * @return
 *     A {@link List<Pair<Integer, Integer>>} where each {@link Pair<>}
 *     will hold the document's ID as its first element and the frequency
 *     of the word in the document as its second element.
 *
 * Note that the {@link Pair} object is defined in javafx.util.Pair
 */  
public static List<Pair<Integer, Integer>> totalWordUses(String word) {
    return entries.values()
                   .stream()
                   .filter(i -> word.equals(i.getWord()))
                   .map(i -> new Pair<>(i.getDocumentId(), i.getFrequency()))
                   .collect(Collectors.toList());
}