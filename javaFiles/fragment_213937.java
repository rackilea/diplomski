do {
    numOfItems = scan.nextInt();
    if (numOfItems == 3 || numOfItems == 5 || numOfItems == 7 || numOfItems == 9) {
        addItems(numOfItems);

    } else {
        System.out.println("That number is out of range.");
        System.out.println("Please choose an odd number in the range of [1, 10] exclusively:");

    }
} while (numOfItems != 3 && numOfItems != 5 && numOfItems != 7 && numOfItems != 9);