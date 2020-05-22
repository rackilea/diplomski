for (int i = arr.length - 1; i >= 0; i--) { // Note the >= 0, which was incorrect
                                            // in the code you posted
    for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j]+" ");
    }
    System.out.println();
}