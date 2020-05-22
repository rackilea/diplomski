public static long asBase3(int num) {
    long ret = 0, factor = 1;
    while (num > 0) {
        ret += num % 3 * factor;
        num /= 3;
        factor *= 10;
    }
    return ret;
}