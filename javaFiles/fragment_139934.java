@Test public void test_ok() throws Exception {
  CompletableFuture<Integer> result = apiCall(1);
  assertEquals(result.get(), (Integer) 1);
}

@Test(expectedExceptions = ExecutionException.class,
      expectedExceptionsMessageRegExp = ".*RuntimeException.*Please not 0!!")
public void test_ex() throws Throwable {
  CompletableFuture<Integer> result = apiCall(0);
  result.get();
}