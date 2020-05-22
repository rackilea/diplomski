public static void main(String[] args) {
    // declare an array (named numbs) that holds 10 ints
    int[] numbs = new int[10];
    // write a for loop that loops 10 times and generates a random number between 0 and 100
    for (int i = 0; i < numbs.length; i++) {
       numbs[i] = (int) (Math.random() * 100 + 1);
    }
    // print the values
    for (int number : numbs) {
       System.out.println(number);
    }
 }