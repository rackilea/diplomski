ExecutorService executor = ... // e.g. Executors.newFixedThreadPool(4);

Future<Void> future = executor.submit(new Callable<Void>() {
    public Void call() throws Exception {
        testA.abc();
        return null;
    }
});
testB.xyz();
future.get(); // wait for completion of testA.abc()