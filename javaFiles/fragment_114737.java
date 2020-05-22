long runUntil = System.currentTimeMillis() + 1000;
ForkJoinPool forkJoinPool = new ForkJoinPool(10); // 10 Threads
forkJoinPool.submit(() ->
IntStream.range(0, 10).parallel().forEach(i -> {
    int cnt = 0;
    while (System.currentTimeMillis() < runUntil)
        cnt++;
    System.out.println(i + ": " + cnt);
})).get();