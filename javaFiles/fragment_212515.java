int arr[][] = new int[10][3];
    int i, j;
    int value = 21;
    for(i =0; i <10;i++) {
        for(j = 0; j <3; j++) {
            arr[i][j] = value;
        }
        value +=20;
    }