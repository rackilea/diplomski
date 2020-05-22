AtomicInteger index=new AtomicInteger()
results.parallelStream().forEach (fab -> {
    int idx=index.getAndIncrement();
    foo_array[idx] = fab.foo_int;
    bar_array[idx] = fab.bar_object;
});