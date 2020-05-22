@Autowired
ThreadPoolTaskExecutor poolExecutor;

CountdownLatch counter = new CountdownLatch(accountIds.size());
IntStream.range(0, accountIds.size()) // Note that .parallel is omitted
         .forEach(() -> poolExecutor.submit(() -> {
             try {
                your task
             } finally {
                counter.countDown();
             }
         })) 
counter.await(); // Wait for all tasks complete