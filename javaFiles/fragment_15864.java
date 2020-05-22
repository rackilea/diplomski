public static int[][] generateRandomPositions(int number, int width, int height){
    int[][] pos = new int[number][2];
    for(int j=0; j <number; j++){
       pos[j][0] = Utility.randomInt(width);
       pos[j][1] = Utility.randomInt(height);
    }
    return pos;
}