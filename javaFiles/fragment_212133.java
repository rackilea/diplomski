int maxValue = 1;
System.out.println("\nMax values in 2D array: ");
for (int i = 0; i < twodArray.length; i++) {
    for (int j = 0; j < twodArray.length; j++)
    if (twodArray[i][j] > maxValue) {
    maxValue = twodArray[i][j];
    }
        System.out.println(maxValue);
    }