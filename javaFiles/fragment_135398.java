public static String remove(int index) {
    // Note the use of "index" instead of "name"
    if (index < 0 || index >= array1.length) {
        // A more common approach is to throw an exception,
        // but your code returns null for out-of-range index
        return null;
    }
    for (int i = index; i < array1.length-1 ; i++) {
        array1[i] = array1[i+1];
    }
    // Unconditionally set null in the last element of the array
    array1[array1.length-1] = null;
    return array1[index]; 
}