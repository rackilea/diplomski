public class Longest {
    public static String longWord(String[] words) {
        //assume initially the longest word is an empty String
        String longestWord = "";
        //loop through each word
        for (String word: words) {
            //check if the each items length with previous largest length
            if (word.length() > longestWord.length()) {
                //make longest word as current if it matches the condition
                longestWord = word;
            }
        }
        //return the longest word,if word array is empty it return empty String
        return longestWord;
    }
}