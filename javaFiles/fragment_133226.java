public static int findValue(int[] array, int value) {
    for (int i = 0; i < array.length; i++) { // iterate over the content of the given array
        if (array[i] == value) { // check if the current entry matches the searched value
            return i; // if it does return the index of the entry
        }
    }
    return -1; // value not found, return -1
}