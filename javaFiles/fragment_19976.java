int[] toBeSorted = new int[10000];
// fill the array with data
int[] copied = new int[10000];
System.arrayCopy(toBeSorted, 0, copied, 0, copied.length);
// prepare the timer, but do not start it
for (int = 0 ; i != 100 ; i++) {
    System.arrayCopy(copied, 0, toBeSorted, 0, copied.length);
    // Now the toBeSorted is in its initial state
    // Start the timer
    Arrays.sort(toBeSorted);
    // Stop the timer before the next iteration
}