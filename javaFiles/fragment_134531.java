while ((number = input.nextInt()) != numberend) {
    System.out.println("Enter an integer, or -99 to quit:");

    //largest & smallest number sorting

    if (number > largest) {
    largest = number;
    }
    if (number < smallest) {
    smallest = number;
    }
}
if (largest > Integer.MIN_VALUE) {
    //calculate final sums
    sum1 = number1 + largest;
    sum2 = number1 + smallest;

    //final statements
    System.out.println("Largest:" + largest);
    System.out.println("Smallest:" + smallest);
    System.out.println("Random:" + number1);
    System.out.println("Largest + Random:" + sum1);
    System.out.println("Smallest + Random:" + sum2);
} else {
    System.out.println("You have entered no numbers");
}