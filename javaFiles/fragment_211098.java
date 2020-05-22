} else if (first.charAt(0) == 'o') {
    String str = "";
    for (int i = 0; i < first.length(); i = i + 2) {
        str += first.charAt(i);
    }
    first = str;
} else if (first.charAt(0) == 'e') {
    String str = "";
    for (int i = 1; i < first.length(); i = i + 2) {
        str += first.charAt(i);
    }
    first = str;
}