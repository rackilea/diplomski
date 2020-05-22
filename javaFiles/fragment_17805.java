public void menuOptionOne() {

    // change
    int counter = 0;
    boolean continueInput = true;
    // end change

    do {
        try {
            if (counter == 0) { // counter is initially set to 0
                System.out.println("Please input the customer's name: ");
                input.nextLine(); // catches the menu input
                customerName = input.nextLine();
                matcher = pattern.matcher(customerName);
                counter++; // increments the counter in case the user's
                            // input is invalid
                if (!matcher.find()) { // if it has non-letter/space
                                        // characters present, throws
                                        // exception
                    throw new Exception("Try again. (Incorrect input: name must contain only letters)");
                }
            } else if (counter > 0) { // asks the user to input name again,
                                        // without the input.nextLine()
                                        // which is intended to catch the
                                        // menu int input
                System.out.println("Please input the customer's name: ");
                customerName = input.nextLine();
                matcher = pattern.matcher(customerName); // checks the input
                                                            // to ensure it
                                                            // is only
                                                            // letters
                                                            // and/or spaces
                if (!matcher.find()) {
                    throw new Exception("Try again. (Incorrect input: name must contain only letters)");
                }
            }
            continueInput = false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    } while (continueInput);
}