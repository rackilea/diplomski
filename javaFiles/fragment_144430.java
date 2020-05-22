if (i % 6 == 5) {
    System.out.println();
    System.out.println("Sum of row " + (rowIndex + 1) + " is: " + sum);
    rowsSum += sum;
    sum = 0;
    rowIndex++;
}