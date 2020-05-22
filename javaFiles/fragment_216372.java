private int work(int i) throws InterruptedException {
    System.out.println( "working... " + i );
    Thread.sleep(i * 1000);
    System.out.println( "worked. " + i );
    return i;
}
public void parallel() throws Exception {
    System.out.println( "parallel start." );
    List<Callable<Integer>> jobs = IntStream.range(0, 100)
      .collect(ArrayList::new, (l,i) -> l.add(() -> work(i)), List::addAll);
    ExecutorService pool = Executors.newFixedThreadPool(10);
    Integer result = pool.invokeAny(jobs);
    pool.shutdown();
    System.out.println( "parallel done, result="+result );
}