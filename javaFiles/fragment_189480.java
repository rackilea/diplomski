private static char[] checkForJ(String encodeInput){
    StringBuilder tempString = new StringBuilder();
    encodeInput = encodeInput.toLowerCase();
    char[] ch  = encodeInput.toCharArray();
    for(char x : ch){
        if(x == ' '){
            x = '-';
            tempString.append(x);
        }else if(x == 'j'){
            x = 'i';
            tempString.append(x);
        }else {
            tempString.append(x);
        }
    }
    String finalString = tempString.toString();
    char[] newChar = finalString.toCharArray();
    return newChar;
}