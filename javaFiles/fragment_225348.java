try {
  int myInt = scanner.nextInt();
  // …
}
catch (InputMismatchException e) {
  System.out.println("Oops!! Please enter only integral numbers");
  System.out.println(scanner.next() + " was not valid input.");
}