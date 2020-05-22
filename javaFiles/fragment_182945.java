for (int i = 1; i < 101; i++) {
    threadPool.submit(new WorkItem(System.currentTimeMillis(), i));
}

for (int i = 101; i < 401; i++) {
    long thisTime = System.currentTimeMillis();
    threadPool.submit(new WorkItem(System.currentTimeMillis(), i));
    while (System.currentTimeMillis() - thisTime < 500) {

    }
}