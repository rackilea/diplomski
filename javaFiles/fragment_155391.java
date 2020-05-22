public static int Diagonal2(int m[][]) {   
    int sum=0;
    for(int row = 0; row < m[0].length; row++) {
        sum += m[row][m.length - row - 1];
    }
    return sum; 
}