int columns = 2;
    int rows = 2;

    String[][] newArray = new String[columns][rows];
    newArray[0][0] = "France";
    newArray[0][1] = "Blue";

    newArray[1][0] = "Ireland";
    newArray[1][1] = "Green";

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < columns; j++){
            System.out.println(newArray[i][j]);
        }
    }