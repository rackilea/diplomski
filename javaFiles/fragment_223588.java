@Rule
public ExpectedException exception = ExpectedException.none();

private static class TestJob implements Callable<Double> {
  private final int index;
  private final int failOnCount;

  TestJob(int index, int failOnCount) {
    this.index = index;
    this.failOnCount = failOnCount;
  }

  @Override
  public Double call() throws RankedException {
    double res = 0;
    int count = (int) (Math.random() * 1e6) + 1;
    if (count > failOnCount) {
      throw new RankedException(count, new RuntimeException("job " + index + " failed"));
    }
    for (int i = 0; i < count; i++) {
      res += Math.random();
    }
    return res;
  }
}

@Test
public void test_success() throws Exception {
  List<TestJob> jobs = Lists.newArrayList();
  for (int i = 0; i < 10; i++) {
    jobs.add(new TestJob(i, (int)(5*1e5))); // 50% should be alright
  }
  CompletableFuture<Double> res = execute(jobs);
  logger.info("SUCCESS-TEST completed with " + res.get(30, TimeUnit.SECONDS));
}

@Test
public void test_failure() throws Exception {
  List<TestJob> jobs = Lists.newArrayList();
  for (int i = 0; i < 10; i++) {
    jobs.add(new TestJob(i, 0)); // all should fail
  }
  CompletableFuture<Double> res = execute(jobs);
  exception.expect(ExecutionException.class);
  try {
    res.get(30, TimeUnit.SECONDS);
  } catch (ExecutionException ex) {
    logger.severe(String.format("FAIL-TEST rank: %s", ((RankedException) ex.getCause()).rank));
    throw ex;
  }
}