class Abc {
    static int[][] arr;

    static {
       arr = new int[100][300];
       for (int i=0;i<arr.length;i++) {
           for (int j=0;j<arr[i].length;j++) {
               arr[i][j] = 7;
           }
       }
    }
}