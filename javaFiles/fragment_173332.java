BlockingQueue<TestCase> testCaseQueue = new LinkedBlockingQueue<>();
for (TestCase test: tests) {
    testCaseQueue.add(test);
}
// now make your executors and run them in a thread-pool
TestExecutor testExecutor =
     new TestExecutor(new FirefoxDriver(), testCaseQueue);
ExecutorService threadPool = Executors.newCachedThreadPool();
threadPool.submit(testExecutor);
...
// once you've submitted your last executor, you shutdown the pool
threadPool.shutdown();

...
// inside of the executor, they dequeue tests from `testCaseQueue`
while (!shutdown) {
    TestCase testCase = testCaseQueue.poll(0, TimeUnit.MILLISECONDS);
    if (testCase == null) {
       break;
    }
    ...
}