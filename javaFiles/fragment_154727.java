public static LN copySwap (LN list, int i1, int i2) {
    if (list == null) {
        return null;
    }
    return new LN(list.value == i1 ? i2 : list.value, copySwap(list.next, i1, i2));
}