int regionCols = colNbr-1;
int[] regionTotals = new int[regionCols];
int stepCounter = 0;
for (int i = 0; i < sales.length; i++) {
    stepCounter++;
    if (stepCounter > regionCols) { stepCounter = 1; }
    int regionIndex = (stepCounter - 1);
    regionTotals[regionIndex]+= sales[i];
}
System.out.println("\nRegion Totals: " + Arrays.toString(regionTotals) + "\n");