public static long multiply(List<Integer> list) {
    long mul = 1;
    for (int i : list) {
        mul *= i;
    }
    return mul;
}