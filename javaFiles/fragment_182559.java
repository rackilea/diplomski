public static boolean isContains (char[] arr, char c) {
    for (int i=0; i<arr.length; i++) {
        if (arr[i] == c) {
            return true;
        }
    }
    return false;
}