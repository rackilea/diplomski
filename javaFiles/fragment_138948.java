int[][] arr = new int[][] { { 1, 4, 5, 4 }, { 7, 6, 4, 2 }, { 1, 1, 2, 3 }, { 1, 2, 2, 5 } };

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + "\t");
        }
        System.out.println();
    }

    // logic begins here
    int rowWithHighestValueInFirstColumn = 1;
    for (int i = 0; i < arr[rowWithHighestValueInFirstColumn].length; i++) {
        // store the value of highest row
        int temp = arr[rowWithHighestValueInFirstColumn][i];
        // swap the value of highest row with first row
        arr[rowWithHighestValueInFirstColumn][i] = arr[0][i];
        // set the value of first row that is stored in temp
        arr[0][i] = temp;
    }
    // logic ends here

    System.out.println("After swapping");
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + "\t");
        }
        System.out.println();
    }