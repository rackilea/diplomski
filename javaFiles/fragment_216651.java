System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
System.out.println("Parallelism: "+ForkJoinPool.getCommonPoolParallelism());
Set<Thread> threads = ConcurrentHashMap.newKeySet();
for(int run=0; run<2; run++) {
    IntStream stream = IntStream.range(0, 100);
    if(run==1) {
        stream = stream.parallel();
        System.out.println("Parallel:");
    }
    int chunks = stream
        .mapToObj(i->Thread.currentThread())
        .collect(()->new int[]{1}, (a,t)->threads.add(t), (a,b)->a[0]+=b[0])[0];
    System.out.println("processed "+chunks+" chunk(s) with "+threads.size()+" thread(s)");
}