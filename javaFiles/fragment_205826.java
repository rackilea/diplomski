public int getCount(Function<Box, Integer> projection) {
    int total = 0;
    for (Box box : boxes) {
        total += projection(box);
    }
    return total;
}