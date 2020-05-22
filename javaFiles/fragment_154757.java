Object arr1[] = { "1", "2", "3" };
    Object arr2[] = { "One", "Two", "Three" };
    Object arr3[] = { "Red", "Blue", "Yellow" };
    //make an array of arrays
    Object allArr[] = { arr1, arr2, arr3 };
    //the new array to store values
    Object arr4[][] = new Object[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0, k = 0; j < 3 && k < 3; j++, k++) {
            //take the first array from array of arrays
            Object tmp[] = (Object[]) allArr[k];
            //take the ith element of each individual array and store in the new array in correct position 
            arr4[i][j] = tmp[i];

        }
    }
     //print the new array
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(arr4[i][j] + " ");
        }
        System.out.println();
    }