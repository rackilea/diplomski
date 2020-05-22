String response = keyboard.next();
while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
  System.out.println("\nInvalid response. Try again.");
  response = keyboard.next();
} 
if (response.equalsIgnoreCase("n")) {
  System.out.println("\nCome back next time, " + customerName + ".");
} else {
  System.out.println("\nGreat! Let's get started.");
}