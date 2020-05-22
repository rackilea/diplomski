char[] messageArray = message.toCharArray();
char[] encryptedMessage = new char[messageArray.length];
int[] numKeyword = obtainKeys(keyword);
int keywordLength = numKeyword.length;

for(int i=0; i<message.length(); i++){
    int shiftAmount = numKeyword[i % keywordLength];
    char c = messageArray[i];
    c = charRightShift(c,shiftAmount);
    encryptedMessage[i] = c;
}