static void placeRandomly1D(int[] arr, int limit) {
// generates value [0...limit) half-interval and places it into the 1D array arr
//    at random position; limit must be positive
    Random rand = new Random();
    int value = rand.nextInt(limit);
    int pos = rand.nextInt(arr.length);
    arr[pos] = value;
}