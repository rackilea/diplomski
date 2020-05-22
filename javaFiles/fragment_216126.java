public static boolean containsAll(int[] listA, int[] listB) {
    outer:
    for (int a : listA) {
        for (int b : listB) {
            if (a == b) {
                continue outer;
            }
        }
        return false;
    }
    return true;
}