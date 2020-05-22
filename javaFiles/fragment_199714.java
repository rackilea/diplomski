int optimizeSmallest(int lower, int upper, BinaryTest testFunction) {
    if (lower > upper || !testFunction.test(upper)) {
        return -1;
    }
    while (lower != upper) {
        int middle = (lower + upper) / 2;
        if (testFunction.test(middle)) {
            upper = middle;
        } else {
            lower = middle + 1;
        }
    }
    return lower;
}