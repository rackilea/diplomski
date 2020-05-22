public int[] remove(int[] original, removeStart, removeEnd) {
    int originalLen = original.length;
    int[] a = new int[originalLen - removeEnd - removeStart];
    System.arraycopy(original, 0, // from original[0]
        a, 0,                     // to a[0]
        removeStart);             // this many elements
    System.arraycopy(original, removeEnd, // from original[removeEnd]
        a, removeStart,                   // to a[removeStart]
        originalLen - removeEnd);         // this many elements
    return a;
}