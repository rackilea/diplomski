public void replaceZeros(double[][] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; i < array[i].length; j++) {
            if (array[i][j] == 0) {
                //check if its first element in a row
                if (j == 0) {
                    array[i][j] = array[i][j + 1];
                }
                //check if its last element in a row
                else if (j == array[i].length - 1) {
                    array[i][j] = array[i][j - 1];
                }
                //proceed with calculating average
                else {
                    array[i][j] = (array[i][j + 1] + array[i][j - 1]) / 2;
                }
            }
        }
    }
}