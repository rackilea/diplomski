public int find(final char[] data, final char key) {
    for (int i = 0; i < data.length; ++i) {
        if (data[i] == key)
            return i;
    }
    return -1;

}