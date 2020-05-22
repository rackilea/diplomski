private void copy(int[] arrayA, int[][] arrayD) {
    int copySize = arrayA.length;
    System.arraycopy(arrayA, 0, arrayD[i], 0, copySize);
    // i should increment every time the 'history' is stored in arrayD
    i++;
}