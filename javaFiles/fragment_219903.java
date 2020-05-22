@Test
@SuppressWarnings("unchecked")
public void testStartComputationAddsRobotsToQueue() {
    ExecutorService pool = mock(ExecutorService.class);
    Future<Integer> future = mock(Future.class);
    when(pool.submit(any(Callable.class)).thenReturn(future);

    ResultCalculator calc = new ResultCalculator(pool);
    calc.startComputation();

    verify(pool, times(5)).submit(any(Callable.class));
}