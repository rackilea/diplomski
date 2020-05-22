String[] needle = "super cold white snow".split("\\s+");
String[] haystack = "white image superdupercold".split("\\s+");
int matchedWords = 0, totalWords = haystack.length;
for (String n : needle) {
    boolean found = false;
    for (String hay : haystack) {
        if (hay.contains(n)) {
            found = true;
            break;
        }
    }
    if (found) matchedWords++;
}