public static int[][] lungimeDrumuri(int[][] array,int n) {

    int[][] newArray= new int[array.length][array.length];
    int[][] tmp= new int[array.length][array.length]; // Just holds values during multiplication between two matrices

    // Initialize newArray to be equal to array
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            newArray[i][j] = array[i][j];
        }
    }

    // Outer loop that multiplies as many times as you want
    for(int k = 1; k < n; k++) {

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array.length;j++){

                int sum = 0;
                for(int x=0;x<array.length;x++){
                    sum+=newArray[i][x]*array[x][j];  // Use newArray here
                }
                tmp[i][j]=sum;
            }
        }

        // Copy the result from multiplication to newArray and restart tmp
        System.arraycopy(tmp, 0, newArray, 0, tmp.length);
        tmp = new int[array.length][array.length];
    }

    return newArray;
}