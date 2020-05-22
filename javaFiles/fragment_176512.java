public static int eucDist(int i, double data[][], double weight[][]) {

    double sum = 0; 
    double min = 10000;
    int saveCol = -1;

    for (int j=0; j<5; j++) {
        for (int k=0; k<5; k++) {
            sum = sum + Math.pow((weight[k][j] - data[i][k]),2);
        }

        double dist = Math.sqrt(sum);

        if(dist < min) {
            min = dist;
            saveCol = j;
        }
    }
    return saveCol;
}