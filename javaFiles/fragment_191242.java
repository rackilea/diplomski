while (read.hasNext()) { // continue while there are tokens left
    if (read.hasNextInt()) { // check if next token is int
        int number = read.nextInt(); // get next int token
        if (number <= 0) {
            System.out.println(number + " - invalid input");
        } else {
            // etc...
        }
    } else { // next token is not int
        String s = read.next(); // get next non-int token
        System.out.println(s + " - invalid input"); // print invalid input
    }
}