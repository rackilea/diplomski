public static double averageRow(int[][] a2) {
    int rowTotal = 0;
    double average = 0;

    for (int row = 0; row < a2.length; row++){
        for (int column = 0; column < a2[row].length; column++){
            rowTotal += a2[row][column];
        }
        average = rowTotal / a2[row].length; // calc average
        System.out.println(average); // print the row average
        rowTotal = 0; // start over (for next row)
    }
    return rowTotal;
}