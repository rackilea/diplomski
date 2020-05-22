public static void main(String[] args) {
    Set<String> combinations = combinate("hello12");
    combinations.forEach(System.out::println);
}

public static Set<String> combinate(String word) {
    // Will hold all the combinations of word
    Set<String> combinations = new HashSet<String>();

    // The word is a combination (could be ignored if empty, though)
    combinations.add(word);

    // Iterate on each word's characters
    for (int i = 0; i < word.toCharArray().length; i++) {
        char character = word.toCharArray()[i];

        // If the character should be replaced...
        if (Character.isDigit(character)) {

            // ... we split the word in two at the character's position & pay attention not be exceed word's length  
            String firstWordPart = word.substring(0, i);
            boolean isWordEnd = i + 1 >= word.length();
            String secondWordPart = isWordEnd ? "" : word.substring(i + 1);

            // Here is the trick: we compute all combinations of the second word part... 
            Set<String> allCombinationsOfSecondPart = combinate(secondWordPart);

            // ... and we append each of them to the first word part one by one
            for (String string : allCombinationsOfSecondPart) {
                String combination = firstWordPart + getSpecialSymbol(character) + string;
                combinations.add(combination);
            }
        }
    }
    return combinations;
}