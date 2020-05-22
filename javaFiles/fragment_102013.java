public static int[] frequency(int [][] matrix){
    int [] nums =[14];      // max value can be 13 so you need 14 element
    int count =0;
    for (int i=0;i<matrix.length;i++){
        for (int j=0; j<matrix[i].length;j++) {
            nums[matrix[i][j]] += 1;
        }
    }
    return nums;
}