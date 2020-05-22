int[][] t = ...
int[] sums = new int[t.length];
int i = 0;
for (int[] row : t) {
   sums[i++] = sumArray(row);
}