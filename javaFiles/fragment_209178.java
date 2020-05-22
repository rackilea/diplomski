try {
  assert false;
  System.out.println("Assertions disabled.");
}
catch(AssertionError ae) {
  System.out.println("Assertions enabled.");
}