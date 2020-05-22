String str = "The array must be in alphabetical order and also store non-alphabetical characters (including spaces)";

char[] charArr = new char[str.length()];
int[] freqArr = new int[str.length()];
int idx = 0;
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    boolean isFound = false;
    for (idx = 0; idx < str.length(); idx++) {
        if (freqArr[idx] == 0) {
            break;
        }
        if (c == charArr[idx]) {
            freqArr[idx]++;
            isFound = true;
            break;
        }
    }
    if (!isFound) {
        charArr[idx] = c;
        freqArr[idx]++;
    }
}

//Sort charArr and freqArr arrays
char tempChar;
int tempFreq;
for (int i = 1; i < str.length(); i++) {
    for (int j = i; j > 0; j--) {
        if (charArr[j] < charArr [j - 1]) {
            tempChar = charArr[j];
            charArr[j] = charArr[j - 1];
            charArr[j - 1] = tempChar;

            tempFreq = freqArr[j];
            freqArr[j] = freqArr[j - 1];
            freqArr[j - 1] = tempFreq;
         }
    }
}