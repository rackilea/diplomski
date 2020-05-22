public static boolean containsAll(int[] listA, int[] listB) {
    for (int a : listA) {
        if (!contains(listB, a)) {
            return false;
        }
    }
    return true;
}

private static boolean contains(int[] list, int i) {
    for (int e : list) {
        if (e == i) {
            return true;
        }
    }
    return false;
}