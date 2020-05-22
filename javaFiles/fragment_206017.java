public static String removeSpecialCharacters(String sentence) {
    //StringBuilder container to store all the data in
    StringBuilder stringB = new StringBuilder();
    //loop trough all the characters from the sentence
    for (char c : sentence.toCharArray()) {
        //only store characters that are equal to the below values
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ' ) {
            stringB.append(c);
        }
    }
    return stringB.toString().toLowerCase();
}