public static int binarySearch(String[] word, int p, int r, String target) {
    int q;
    if (p > r) {
        return -1;
    } else {
        q = (p + r) / 2;
        if (target.trim().equals(word[q].trim())) {
            return q;
        } else if (target.compareTo(word[q]) < 0) {
            return binarySearch(word, p, q - 1, target);
        } else {
            return binarySearch(word, q + 1, r, target);
        }
    }
}