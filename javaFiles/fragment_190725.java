public void replaceBlank(char letter) {
    char[] secret = getSecretWord().toCharArray();
    for (int i = 0; i < secret.length; ++i) {
        if (secret[i] == letter) {
            charArray[i] = letter;
        }
    }
}