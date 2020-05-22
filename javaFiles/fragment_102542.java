public static boolean checking(String[] dictionary, String userWord) {
    for ( int i =0; i < dictionary.length; i++) {
        if (userWord.equals(dictionary[i])) {
            return true;
        }
    }
    return false;
}