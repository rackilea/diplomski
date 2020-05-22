public String getMessage() {
  super.getValue1();    // <-- sets d1.
  super.getValue2();    // <-- sets d2
  total=super.getSum(); // <-- adds d1 and d2.
  if (total == 7) {
    System.out.println("CRAPS!");
  } else if (total == 12) {
    System.out.println("BOX CARS!");
  } else if (total == 2) {
    System.out.println("SNAKE EYES!");
  } else {
    System.out.println("");
  }
  return "";
}