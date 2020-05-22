int[][] another = int[2][7];
for (int i = 0; i < array.length; i++) {
   for (int j = 0; j < array.length; j++) {
      anotner[i][j] = array[i][j][0];
   }
}
for (int[] a : anotner) {
    Arrays.sort(a);
}