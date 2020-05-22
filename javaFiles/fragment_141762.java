int numRows = 2;
    int numColumns = 3;
    char currentColumnLetter;
    for (int currentRow = 1; currentRow <= numRows; currentRow++) {
        currentColumnLetter = 'A';
        for (int currentColumn = 1; currentColumn <= numColumns; currentColumn++) {
            System.out.print("" + currentRow + currentColumnLetter + " ");
            currentColumnLetter++;
        }
    }