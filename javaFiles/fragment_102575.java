try {
  // something that should cause an exception
  fail("Exception expected");
} catch (ExactlyTheRightException e) {
  // ignored
}