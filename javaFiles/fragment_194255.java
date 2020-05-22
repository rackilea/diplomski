try {
  // some code that can throw both checked and runtime exception

} catch (Exception e) {
  throw rethrow(e);
}