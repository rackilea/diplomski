public final class ListObservingCacheTest
{
    @Mocked DummyTask mockTask;
    final int refreshIntervalMillis = 30;
    final List<Integer> initialItems = asList(1, 2);
    final List<Integer> newItemsAfterRefreshInterval = asList(3, 4, 5);

    @Before
    public void arrangeTaskOutputForMultipleCalls() {
        new Expectations() {{
            mockTask.acquireList();
            result = initialItems;
            result = newItemsAfterRefreshInterval;
        }};

        // A trick to avoid a long initial delay before the scheduled task is first
        // executed (a better solution might be to change the SUT to read the
        // initial delay from a system property).
        new MockUp<ScheduledThreadPoolExecutor>() {
            @Mock
            ScheduledFuture<?> scheduleAtFixedRate(
                Invocation inv,
                Runnable command, long initialDelay, long period, TimeUnit unit
            ) {
                return inv.proceed(command, 0, period, unit);
            }
        };
    }

    @After
    public void shutdownTheExecutorService() {
        ScheduledExecutorService executorService = 
            Deencapsulation.getField(ObservingCache.class, ScheduledExecutorService.class);
        executorService.shutdown();
    }

    @Test
    public void getTheInitialItemsImmediatellyAfterCreatingTheCache() throws Exception {
        // Arrange: empty, as there is nothing left to do beyond what the setup method
        // already does.

        // Act:
        ListObservingCache<Integer> obsCache = 
            new ListObservingCache<>(() -> mockTask.acquireList(), refreshIntervalMillis);
        List<Integer> items = obsCache.getItems();

        // Assert:
        assertEquals(initialItems, items);
    }

    @Test
    public void getTheSameItemsMultipleTimesBeforeTheCacheRefreshIntervalExpires() throws Exception {
        // Act:
        ListObservingCache<Integer> obsCache = 
            new ListObservingCache<>(() -> mockTask.acquireList(), refreshIntervalMillis);
        List<Integer> items1 = obsCache.getItems();
        List<Integer> items2 = obsCache.getItems();
        List<Integer> itemsIfTaskGotToBeCalledAgain = mockTask.acquireList();
        List<Integer> items3 = obsCache.getItems();

        // Assert:
        assertEquals(initialItems, items1);
        assertEquals(initialItems, items2);
        assertEquals(initialItems, items3);
        assertEquals(newItemsAfterRefreshInterval, itemsIfTaskGotToBeCalledAgain);
    }

    @Test
    public void getNewItemsAfterTheCacheRefreshIntervalExpires() throws Exception {
        // Act:
        ListObservingCache<Integer> obsCache = 
            new ListObservingCache<>(() -> mockTask.acquireList(), refreshIntervalMillis);
        List<Integer> items1 = obsCache.getItems();
        Thread.sleep(refreshIntervalMillis);
        List<Integer> items2 = obsCache.getItems();

        // Assert:
        assertEquals(initialItems, items1);
        assertEquals(newItemsAfterRefreshInterval, items2);
    }
}