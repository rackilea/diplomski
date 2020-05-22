@Test(expectedExceptions = RuntimeException.class,
      expectedExceptionsMessageRegExp = "'authority' Uri should have at least one segment in the path \\(i.e. https://<host>/<path>/...\\)")
public void test() {
    String input = "'authority' Uri should have at least one segment in the path (i.e. https://<host>/<path>/...)";
    throw new RuntimeException(input);
}