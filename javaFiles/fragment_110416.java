int[][] newMatrix = new int[imgMatrix.length][];
    for (int a=0; a < imgMatrix.length; a++) { // remove = from older code

        newMatrix[a] = new int[imgMatrix[a].length];

        for (int b=0; b < imgMatrix[a].length; b++) { // remove = from older code
           //remove : for (c=0; c <= imgMatrix[a].length; c++) {
                if (imgMatrix[a][b] <= 0.5) {
                    newMatrix[a][b] = 0;
                }
                else {
                    newMatrix[a][b] = 1;
                }
         // remove :   }
        }
    }