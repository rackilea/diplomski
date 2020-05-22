while (true) {
    // generate a random number in the range [-1000, 1000):
    final double randomNum = 2000 * Math.random() - 1000;

    // print it if it's in the range [-1000, -999):
    if (randomNum < -999) {
         System.out.println("Random Num: " + randomNum);
    }
}