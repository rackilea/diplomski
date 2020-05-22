Future<Void> future = executor.submit(new Callable<Void>() {
    public Void call() throws Exception {
        testA.abc();
        return null;
    }
});