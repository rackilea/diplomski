// Map with the longest word for each letter
Map<Character, String> longestWordMap = new HashMap<Character, String>();
// Map with the word with highest occurrences of each letter
Map<Character, String> mostCharsWordMap = new HashMap<Character, String>();

while((word = br.readLine()) != null) { {
    word = word.toLowerCase();
    Character beginning = word.charAt(0);
    String longestWord = longestWordMap.get(beginning);
    // If the current word is the longest, put the word in the map
    if (longestWord == null || word.length() > longestWord.length()) {
            longestWordMap.put(beginning, word);
    }
    for (char letter = 'a'; letter <= 'z'; letter++) {
        String mostCharsWord = mostCharsWordMap.get(Character.valueOf(letter));
        if (mostCharsWord == null || 
            characterCount(letter, word) > characterCount(letter, mostCharsWord)) {
            mostCharsWordMap.put(Character.valueOf(letter), word);
        }
    }
}