private int compareKeys(final String first, final String second) {
    if (first == null || second == null) {
        return 0; // TODO: 0, here?
    } else {
        return first.compareTo(second);
    }
}