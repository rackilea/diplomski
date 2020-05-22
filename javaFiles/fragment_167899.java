public long howHigh(long N) {
    long upper = 1;
    while (f(upper + 1) <= N) {
        upper *= 2;
    }
    long lower = upper / 2, mid = -1;
    while (lower < upper) {
        mid = (lower + upper) / 2;
        if (f(mid + 1) > N) {
            upper = mid;
        }
        else {
            lower = mid + 1;
        }
    }
    return lower;
}