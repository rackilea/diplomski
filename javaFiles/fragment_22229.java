public void assertThrows(Runnable block) {
  try {
    block.run();
    fail("Block didn't throw.");
  } catch (Exception ex) { }
}