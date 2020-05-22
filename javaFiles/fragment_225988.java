static void placeRandomly2D(int[][] arr, int limit) {
// generates value [0...limit) half-interval and places it into the 2D array arr
//    at random position; limit must be positive
    Random rand = new Random();
    int value = rand.nextInt(limit);
    int pos1 = rand.nextInt(arr.length);
    int pos2 = rand.nextInt(arr[pos1].length);
    arr[pos1][pos2] = value;
}