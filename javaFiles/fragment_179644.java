public Object construct() {
  for (;;) {
    Node.execution();
    Clock.incrementTimeTick();
    System.out.println(Clock.getTimeInTick());
    repaint();
  }
  // End of loop is unreachable, so no need for a return statement.
}