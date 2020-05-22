try {
  return list.getLast();
} catch (Exception e) {
  System.err.println("Caught: " + e);
  throw e; // re-throw
}
// no "return" outside since we'll have thrown our previously caught error.