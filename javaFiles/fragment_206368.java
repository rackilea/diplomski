static int findPath3(long from, long to) {
    int len = 0;
    while (from != to) {
        if (from % 5 == 0 && from / 5 >= to) {
            from /= 5;
        } else if (from % 3 == 0 && from / 3 >= to) {
            from /= 3;
        } else {
            from--;
        }
        len++;
    }
    return len;
}