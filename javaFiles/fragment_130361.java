public static int[][] x(int one[][],int two[][],int i,int j,int sum[][]) {
    if (j == one[i].length) {
        if (i == one.length - 1)
            return sum;
        i++;
        j = 0;
    }
    sum[i][j] = one[i][j] + two[i][j];
    return x(one, two, i, j + 1, sum);
}