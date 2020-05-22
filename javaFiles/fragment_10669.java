try {
  ...
} catch (final SomeException theOriginalCause) {
  // throw new SomeOtherException(); // Bad !
  throw new SomeOtherException(theOriginalCause); // Good.
}