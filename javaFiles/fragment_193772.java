public static <T> T[] arrayConcat(T[]... arrays) {
    int totalLen = 0;
    for (T[] arr: arrays) {
        totalLen += arr.length;
    }
    T[] all = (T[])Array.newInstance(
        arrays.getClass().getComponentType().getComponentType(), totalLen);
    int copied = 0;
    for (T[] arr: arrays) {
        System.arraycopy(arr, 0, all, copied, arr.length);
        copied += arr.length;
    }
    return all;
}