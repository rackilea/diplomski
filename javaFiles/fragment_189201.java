boolean isDateValid = false;
 do {
    System.out.println("Please enter 3 integers to represent a valid date:");
    day = scan.nextInt();
    month = scan.nextInt();
    year = scan.nextInt();
    isDateValid = ... that lengthy conditition
    if (!isDateValid) {
      System.out.println("The original date/month/year is invalid; please try again");
    }
 } while (!isDateValid)