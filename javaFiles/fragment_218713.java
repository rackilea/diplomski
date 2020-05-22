String decrypt(String encryptedString) {
    int i = encryptedString.length() - 1;
    String result = "" ;  // use a String builder in real life of course

    for (int i = encryptedString.length() - 1   // last index
            ; i >= 0
            ; i -= (diff + 1) ) {
        result += encryptedString[i];
    }
    return result;
}