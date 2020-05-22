MethodClass[][] methodArray = new MethodClass[1][1]; //You can put any dimentions to this array, below for loop will initialize all the positions.

    for (int i = 0; i < methodArray.length; i++){
        for (int j = 0; j < methodArray[i].length; j++) {
            methodArray[i][j] = new MethodClass();
        }
    }