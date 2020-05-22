public static void main(String[] args) {
    String original = "this is my car";

    String[] singleWords = original.split(" ");  // split the String to get the single words
    ArrayList<String> results = new ArrayList<String>();  // a container for all the possible sentences
    for (int startWord = 0; startWord < singleWords.length; startWord++) {  // starWords start with 0 and increment just until they reach the last word
        for (int lastWord = singleWords.length; lastWord > startWord; lastWord--) { // last words start at the end and decrement just until they reached the first word 
            String next = "";
            for (int i = startWord; i != lastWord; i++) { // put all words in one String (starting with the startWord and ending with the lastWord)
                next += singleWords[i] + " "; 
            }
            results.add(next);  // add the next result to your result list
        }
    }

    // this is just to check the results. All your sentences are now stored in the ArrayList results
    for (String string : results) {
        System.out.println("" + string);
    }
}