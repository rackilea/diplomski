function int sumLengths(String[] strings) {
    int counter = 0;
    int length = (strings != null) ? strings.length : -1;
    for (int idx = 0; idx < length; ++idx) {
        counter += strings[idx].length();
    }
    return counter;
}