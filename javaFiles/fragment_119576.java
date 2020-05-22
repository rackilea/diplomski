for (int i = 0; i < messageArray.length; i++) {
    char c = messageArray[i];
    if (c >= 'A' && c <= 'Z') {
       plainLetterIndex = c - 65; //A is ASCII 65

       encryptedIndex = (char) (plainLetterIndex + encryptKey) % 26;
       encryptedChar = alphaArray[encryptedIndex];

       encryptedMessageArray[i] = encryptedChar;
   } else {
       encryptedMessageArray[i] = messageArray[i];
   }
}