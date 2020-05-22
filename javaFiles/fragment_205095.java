String[][] twoDArray = new String[][] {
        new String[] {"Row1Col1", "Row1Col2", "Row1Col3"},
        new String[] {"Row2Col1", "Row2Col2"},
        new String[] {"Row3Col1", "Row3Col2", "Row3Col3", "Row3Col4"}
};

boolean recordFound = true;
int colIndex = 0;
while(recordFound) {
    recordFound = false;
    for(int row=0; row<twoDArray.length; row++) {
        String[] rowArray = twoDArray[row];
        if(colIndex < rowArray.length) {
            System.out.println(rowArray[colIndex]);
            recordFound = true;
        }
    }
    colIndex++;
}