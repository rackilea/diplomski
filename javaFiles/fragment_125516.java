while (!keyboard.hasNextInt()) {
    entry = keyboard.next();
    System.out.println("That is not an integer.  " + "Please try again.");
}
numberEntered = keyboard.nextInt();
System.out.print(numberEntered);
return numberEntered;