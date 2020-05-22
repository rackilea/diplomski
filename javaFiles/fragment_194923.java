if (test.hasInt()) {
    int quantity = test.nextInt();
    // We could use a case statement here, but for simplicity...
    if ("special".equalsIgnoreCase(parts[0])) {
        specials += quantity;
    } else if ("salad".equalsIgnoreCase(parts[0])) {
        salads += quantity;
    } else if ("hamburger".equalsIgnoreCase(parts[0])) {
        hamburger += quantity;
    } else {
        System.out.println(parts[0] + " is not a valid entree");
    }