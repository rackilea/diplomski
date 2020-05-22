int[] counts = new int[10];
for (int r = 0 ; r != array.length ; r++) {
    for (int c = 0 ; c != array[r].length ; c++) {
        counts[array[r][c]]++;
    }
}