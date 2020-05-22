for (currPos = 0; currPos < strLen - 1; currPos++) {
    currLet = str.charAt(currPos);
    //System.out.println("Curr char: "+currLet+"  Next Char: "+str.charAt(currPos+1));
    if (currLet == str.charAt(currPos + 1)) {
        currLen++;
    } else if (currLen > maxLen) {
        maxLen = currLen;
        currLen = 1;
    } else {
        currLen = 1;
    }
}
if (currLen > maxLen) {
    maxLen = currLen;
}