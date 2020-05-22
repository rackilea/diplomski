input = kyb.nextLine().toLowerCase();

if (! (input.equals("air") || input.equals("water") || input.equals("steel")) ) {
  System.out.println("Invalid input. Exit");
  return;
}