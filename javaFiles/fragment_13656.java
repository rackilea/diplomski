private int[] getMaxFromGrids(int k, int[][] yourArray){

    int m = yourArray.length;    //height of grid
    int n = yourArray[0].length; //width of grid, assuming that all inner array have same length!
                                 //argument k is size of smaller grid

    //computing max possibilities to fit smaller grid to larger one
    int maxPossibilities = (m - k + 1) * (n - k + 1);

    if(maxPossibilities < 1 || k < 1) return null;

    int[] maxValuesSmallGrid = new int[maxPossibilities];
    for (int i = 0; i < (maxPossibilities); i++) {

        //computing actual start element for small grid
        int colStartElement = i % (n - (k - 1));
        int rowStartElement = i / (n - (k - 1));

        //creating smaller grid
        int[] smallGrid = new int[k * k];
        int o = 0; //index of smaller grid
        for (int j = colStartElement; j < colStartElement + k; j++) {
            for (int l = rowStartElement; l < rowStartElement + k; l++) {
                smallGrid[o++] = yourArray[j][l];
            }
        }

        maxValuesSmallGrid[i] = getMax(smallGrid);
    }

    return maxValuesSmallGrid;
}

//method for getting max number from given array
private int getMax(int[] numbers) {
    int max = Integer.MIN_VALUE;
    for(int num : numbers) {
        if(num > max) max = num;
    }
    return max;
}