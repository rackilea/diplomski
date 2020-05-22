public boolean checkPattern(String str) {
    String pattern = "";
    for (int i = 0; i < str.length()/2; i++) {
        pattern += str.charAt(i);
        if (str.length() % pattern.length() == 0 && isRepeating(str, pattern)) {
            return true;
        }
    }
    return false;
}

public boolean isRepeating(String str, String pattern) {
    String leftover = str;
    int currIndex = leftover.indexOf(pattern);
    while (currIndex == 0) {
        if(currIndex + pattern.length() == leftover.length()) {
            return true; // you have reached the last possible instance of the pattern at this point
        }
        leftover = leftover.substring(currIndex + pattern.length());
        currIndex = leftover.indexOf(pattern);
    }
    return false;
}