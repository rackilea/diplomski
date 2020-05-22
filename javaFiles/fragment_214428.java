public static int findNth(String text, String find, int nth) {
    int last = -1;
    for (int i = 0; i < nth; i++) {
        last = text.indexOf(find, last + 1);
        if (last == -1) return -1;
    }
    return last;
}