if (parts.length == 2) {
    // We user another Scanner, as this can determine if the String
    // is an `int` value (or at least starts with one)
    Scanner test = new Scanner(parts[1]);
    if (test.hasInt()) {
        int quantity = test.nextInt();
        // continue processing...
    } else {
        System.out.println(parts[1] + " is not a valid quantity");
    }