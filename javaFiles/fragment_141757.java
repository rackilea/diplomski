for (int i = 0; i < (myArray.length - 1); i++) {
    for (int j = 0; j < myArray.length - i - 1; j++) {
        if (myArray[j] > myArray[j + 1]) {
            char swap = myArray[j];
            myArray[j] = myArray[j + 1];
            myArray[j + 1] = swap;
        }
    }
}