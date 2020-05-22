loop: while (true) {
  int decision = scan.nextInt();

  switch (decision) { 
    case 1:
      //example
      break;
    case 2:
      //example and so on
      break;
    case 3:
      break;
    case 9:
      // Quit
      System.out.println("You decided to Quit");
      break loop;
    default:
      // Wrong decision
      System.out.println("Select a number between 1 and 8 to make a decision or 9 to Quit");
  }
  //exit program code here
}