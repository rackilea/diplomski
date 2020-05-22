public static int findNth(String text, String toFind, int count) {
    int pos = -1;
    do {
        pos = text.indexOf(toFind, pos+1);
    } while(--count > 0 && pos >= 0);
    return pos;
}

int from = findNth(text, "_", 3);
int to = findNth(text, "^", 3);
String found = text.substring(from+1, to);