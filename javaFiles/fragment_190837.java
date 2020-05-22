boolean isContinuing = true;

while (isContinuing) {
    // do work

    boolean inputIsInvalid = true;
    while (inputIsInvalid) {
      System.out.print("Continue? (y/n): ");

      String choice = sc.next();

      if ("y".equalsIgnoreCase(choice)) {
          inputIsInvalid = false;
      }
      else if ("n".equalsIgnoreCase(choice)) {
          inputIsInvalid = false;
          isContinuing = false;
      }
      else {
          System.err.print("Error: Only valid answers are Y/N.");
      }
    }
}