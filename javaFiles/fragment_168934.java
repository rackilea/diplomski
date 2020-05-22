public Pair search(double[][] data) {
    int x = -1;
    int y = -1;
    for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
            if (data[i][j] == 1.0) {
                x = i;
                y = j;              
                break;
            }

        }
    }
    return new Pair(x, y);
}