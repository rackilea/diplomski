public static boolean contains(String[] arr1, String[] arr2) {
    int length = 0;

    for (int i = 0; i < arr1.length; i++) {
        if (arr2[length].equals(arr1[i])) {
            length++;
        } else {
            length = 0;
        }
        if (length == arr2.length)
            return true;
    }
    return false;
}