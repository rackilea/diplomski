int[][] list = {{1,2},{3,4}};
int row = 2;
int column = 5;
int [][] renewed = new int[row*list.length][column*list[0].length];
for (int i = 0; i < renewed.length; i++) {
    for (int j = 0; j < renewed[0].length; j++) {
        renewed[i][j] = list[i % list.length][j % list[0].length];
    }
}
System.out.println(Arrays.deepToString(renewed));