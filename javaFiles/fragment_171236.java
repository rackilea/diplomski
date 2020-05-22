public static String reverseString(String inString) {
    String resultString = "";//This is the resulting string, it is empty but we will add things in the next for loop
    if(inString.length()>0) {//Check the string for a lenght greater than 0
        //here we set a number to the strings lenght-1 because we start counting at 0
        //and go down to 0 and add the character at that position in the original string to the resulting one
        for(int stringCharIndex=inString.length()-1;stringCharIndex>=0;stringCharIndex--) {
            resultString+=inString.charAt(stringCharIndex);
        }
    }
    //finaly return the resulting string.
    return resultString;
}