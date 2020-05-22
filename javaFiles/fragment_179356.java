@Autowired
private DSLContext db;
@Autowired
private Runnable selector;
@Autowired
private Runnable inserter;

private final ThreadPoolExecutor THREAD_POOL = (ThreadPoolExecutor) Executors.newCachedThreadPool();

@Test
@FlywayTest
public void runTest() throws InterruptedException {
    log.debug("Starting test");
    int count0 = db.selectCount().from(SYSTEM_LOG).fetchOne(0, int.class);
    assertTrue(count0 == 0);

    THREAD_POOL.execute(inserter);
    THREAD_POOL.execute(selector);

    THREAD_POOL.shutdown();
    THREAD_POOL.awaitTermination(5, TimeUnit.SECONDS);
    log.debug("Terminated");
}