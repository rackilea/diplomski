while ((number = input.nextInt()) != numberend || largest == Integer.MIN_VALUE) {
    while (number == numberend) {
        System.out.println("You have entered no numbers, you can't quit");
        number = input.nextInt();
    }
    System.out.println("Enter an integer, or -99 to quit:");

    //largest & smallest number sorting

    if (number > largest) {
    largest = number;
    }
    if (number < smallest) {
    smallest = number;
    }
}