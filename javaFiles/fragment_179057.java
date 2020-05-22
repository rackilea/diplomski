public static void assignCellTypes(char[][] tissue, int percentBlank, int percentX){

    //Your code goes here
    Random rnd = new Random();
    int row = 0;
    int col = 0;
    int rndRow = rnd.nextInt(tissue.length);
    int rndCol = rnd.nextInt(tissue.length);

    int numOfCells = (tissue.length * tissue.length);
    double numOfBlankCells = numOfCells * (percentBlank/100.0);
    numOfBlankCells = Math.ceil(numOfBlankCells);
    double numOfXCells = (numOfCells-numOfBlankCells) * (percentX/100.0);
    numOfXCells = Math.ceil(numOfXCells);
    double numOfOCells = numOfCells - (numOfBlankCells + numOfXCells);

    if (numOfCells < numOfBlankCells + numOfXCells + numOfOCells) {
        System.out.println("Percentages can't be over 100%");
        System.exit(0);
    }

    int counterBlank = 0;
    while (counterBlank < numOfBlankCells) {
        rndRow = rnd.nextInt(tissue.length);
        rndCol = rnd.nextInt(tissue.length);
        if (tissue[rndRow][rndCol] == '\0') {
            tissue[rndRow][rndCol] = ' ';
            counterBlank++;
        }   
    }
    int counterX = 0;
    while (counterX < numOfXCells) {
        rndRow = rnd.nextInt(tissue.length);
        rndCol = rnd.nextInt(tissue.length);
        if (tissue[rndRow][rndCol] == '\0') {
            tissue[rndRow][rndCol] = 'X';
            counterX++;
        } 
    }
    int counterO = 0;
    while (counterO < numOfOCells) {
        rndRow = rnd.nextInt(tissue.length);
        rndCol = rnd.nextInt(tissue.length);
        if (tissue[rndRow][rndCol] == '\0') {
            tissue[rndRow][rndCol] = 'O';
            counterO++;
        }
    }       
}