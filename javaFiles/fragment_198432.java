ExecutorService es = Executors.newFixedThreadPool(1);

Future<?> result = es.submit(new Runnable() {
    @Override
    public void run() {
        throw new Error("sample error");
    }
});

try {
    result.get();
} catch (ExecutionException e) {
    e.printStackTrace();
}