boolean running = true;
...
while (running) {
  ...
  String response;
  boolean validResponse = false;

  while (!validResponse) {
    System.out.println("Do you want to end the program? Please enter yes or no: ");
    response = input.next();
    running = isContinueResponse(response);
    validResponse = isValidResponse(response);

    if (!validResponse) System.out.println("That is an invalid input!");
  }
}