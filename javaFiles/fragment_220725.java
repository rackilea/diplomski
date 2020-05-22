public static String SQLFormatter(String list) {
String ret = "";
String currentWord = "";
boolean firstWord = true;
for (int i = 0; i < list.length(); i++) {
    // note modified to prepend comma to words beyond first and treat any white space as separator
    // but multiple whitespace is treated as if just one space
    char c = list.charAt(i);
    if (!Character.isWhitespace(c)) {
        currentWord += c;
    } else if (!currentWord.equals("")) {
        currentWord = '\'' + currentWord + '\'';
        if (firstWord) {
            ret += currentWord;
            firstWord = false;
        } else {
            ret = ret + ',' + currentWord;
        }
        currentWord = "";
    }
}


return ret;
}