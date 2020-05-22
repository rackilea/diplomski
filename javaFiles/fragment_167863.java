double lowest = Double.parseDouble(excelMatrix[0][0]);
int row = 0, column = 0;

for(int r = 0; r< excelMatrix.length; r++) {
    for(int c = 0; c<excelMatrix[r].length; c++) {
        double number = Double.parseDouble(excelMatrix[r][c]);
        if(lowest > number) {
            lowest = number;
            row = r, column = c;
        }
    }
}
System.out.print(lowest + " at row: " + row + "and column: " + column);