public static<T> String[] toStringArr(T arr[]) {
    if (arr == null) return null;
    String ret[] = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != null) {
            ret[i] = arr[i].toString();
        }
    }
    return ret;
}