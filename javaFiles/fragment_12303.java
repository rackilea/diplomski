do {
  try {
    System.out.print("Amount: ");
    input = scan.nextInt();
    loop = false;             // Reset the variable here.
    if (input < 0) {
      System.out.println("Error. Invalid amount entered.");
      loop = true;
    }
  } catch (Exception e) {
    System.out.println("Error: Invalid input");
    scan.next();             // This is to consume the new line character from the previous wrong input.
    loop = true;
  }
} while (loop);