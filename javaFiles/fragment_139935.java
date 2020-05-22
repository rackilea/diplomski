@Test(expectedExceptions = RuntimeException.class,
      expectedExceptionsMessageRegExp = "Please not 0!!")
public void test_ex() throws Throwable {
  CompletableFuture<Integer> result = apiCall(0);
  try {
    result.get();
  } catch (ExecutionException e) {
    throw e.getCause();
  }
}