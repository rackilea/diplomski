static String[][][] makeArray(int[][] dimensions) {
   String[][][] myArray = new String[25][25][1];
       for (int i = 0; i < dimensions.length; i++) {
           for (int j = 0; j < dimensions[i].length; j++) {
               myArray[i][j][0] = i + "," + j;
           }

       }
       return myArray;
}