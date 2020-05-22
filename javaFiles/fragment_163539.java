int hanCodePoint = "".codePointAt(0);
for (int i = 0; i < string.length();) {
    int currentCodePoint = string.codePointAt(i);
    if (currentCodePoint == hanCodePoint) {
        // do something here.
    }
    i += Character.charCount(currentCodePoint);
}