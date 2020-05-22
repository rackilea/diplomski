int level = 0;
boolean gotLevel = false;

while (!gotLevel) {
  try {
    level = input.nextInt();
    gotLevel = true;
  } catch (InputMismatchException e) {
    System.out.println("Error. " + input.next() + " is not a valid integer:" + e);
  }
}