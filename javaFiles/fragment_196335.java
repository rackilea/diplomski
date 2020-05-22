String returnString="";
    for (int index = 0; index < original.length();) {
        char currentChar = original.charAt(index);
        int counter=1;
        while(++index < original.length() && currentChar==original.charAt(index)) {
            counter++;
        }
        returnString=returnString+counter+currentChar;
    }
    return returnString;
}