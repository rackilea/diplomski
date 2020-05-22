int[][] triangle = new int[10][];
for(int i = 0; i < triangle.length; i++){
    triangle[i] = new int[i+1];
    for(int j = 0; j < triangle[i].length; j++){
        triangle[i][j] = j;
    }
}