public class Longest {
    public static String longWord(String[] word) {
        //sort the array based on the length,So that
        // largest element will be at the end of the array
        Arrays.sort(word, Comparator.comparing(String::length));
        //return the last element
        return word[word.length-1];
    }
}