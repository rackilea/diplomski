ExecutorService executor = Executors.newCachedThreadPool();

Iterator<Long> i = getUserIDs();
while (i.hasNext()) {
    final Long l = i.next();

    Runnable task = new Runnable() {
        public void run() {
            someObject.doSomething(l);
            anotheObject.doSomething(l);
        }
    }

    executor.submit(task);
}

executor.shutdown();