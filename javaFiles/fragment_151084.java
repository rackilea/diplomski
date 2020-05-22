// returns true if a result string contains key 
// (or any combination of its letters in order)
private boolean contains(String result, String key) {
    // make both strings lowercase and remove spaces
    result = result.toLowerCase().replace(" ", "");  
    key = key.toLowerCase().replace(" ", "");

    // use a char array
    char[] letters = key.toCharArray();

    // loop through it
    for (char c : letters) {
        if (!result.contains(c + "")) {
            return false;   // stop searching if can't find at least one char
        }

        // remove the first part of the string, so that we're searching for 
        // letters that exist in a string in order they appear in the key.
        result = result.substring(result.indexOf(c));
    }

    return true;
}