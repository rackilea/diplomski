public static void main(String[] args) {
    int triangles = 5;

    //initialize column count
    int columns = triangles * 2 - 1;
    int[] starsPerRow= new int[triangles];

    //how many stars in each row
    for (int i=0; i<triangles; i++) {
        starsPerRow[i] = i*2+1;
    }

    //create a triangle "template". only one triangle map
    char[][] triangeMatrix = new char[triangles][columns];
    for (int i=0; i<triangles; i++) {
        for (int j=0; j<(columns - starsPerRow[i])/2; j++) {
            triangeMatrix[i][j] = ' ';
        }
        for (int j=0; j<starsPerRow[i]; j++) {
            triangeMatrix[i][j + (columns - starsPerRow[i])/2] = '*';               
        }
        for (int j=0; j<(columns - starsPerRow[i])/2; j++) {
            triangeMatrix[i][j + (columns + starsPerRow[i])/2] = ' ';               
        }
    }

    //print triangle map n times
    for (int i=0; i<triangles; i++) {
        for (int j=0; j<triangles; j++) {
            for (int k=0; k<columns; k++) {
                System.out.print(triangeMatrix[i][k]);
            }
        }
        System.out.println();
    }

}