executorService.submit(new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
        System.out.println("Starting");
        int n = new Random().nextInt(4000);
        // try-catch-finally omitted
        return n;  
    }}
);