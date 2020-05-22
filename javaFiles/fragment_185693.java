try {
  for (final E item : myCollection) {
     doSomething(item)
  }
} catch (final Exception ex) {
  return "blah";
}