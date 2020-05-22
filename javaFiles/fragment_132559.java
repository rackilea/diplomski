public void process(String word) {
    // Convert word to array of letters
    char[] letters = word.toCharArray();
    // Run through all positions in the word
    for (int pos=0; pos<letters.length; pos++) {
        // Run through all letters for the current position
        for (char letter='a'; letter<='z'; letter++) {
            // Replace the letter
            letters[pos] = letter;
            // Re-create a string and print it out
            System.out.println(new String(letters));
        }
        // Set the current letter back to what it was
        letters[pos] = word.charAt(pos);
    }
}