int[][] coords = new int[height][width];
int multiplier = 10;
for (int i = 0;i < height;i++) {
    for (int j = 1;j < width;j++){
        coords[i][j] = j*multiplier;
    }
}
for (int i = 0;i < height-1;i++) {
    for (int j = 1;j < width;j++){
        System.out.print("(" + i*multiplier + "," + coords[i][j] + ")");
    }
    System.out.println();
}