for (int i = 0; i < messageArray.length; i++) {
    boolean isCharEncrypted = false;
    for (int k = 0; k < alphaArray.length; k++) {
        if (messageArray[i] == alphaArray[k]) {
            plainLetterIndex = k;

            encryptedIndex = (char)(plainLetterIndex + encryptKey) % 26;
            encryptedChar = alphaArray[encryptedIndex];

            encryptedMessageArray[i] = encryptedChar; 
            isCharEncrypted = true;
        }
    }
    if (!isCharEncrypted) {
        encryptedMessageArray[i] = messageArray[i];
    }
}