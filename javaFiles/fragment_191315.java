public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.submit(new PathScanner());
    service.submit(new Counter());

    service.shutdown();
    service.awaitTermination(1, TimeUnit.DAYS);

    System.exit(0);
}

public static class PathScanner implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        scan(new File("C:/"), 0);
        return null;
    }

    protected void scan(File path, int deepth) {
        if (deepth < 15) {
            System.out.println("Scanning " + path + " at a deepth of " + deepth);

            File[] files = path.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file, ++deepth);
                }
            }
        }
    }
}

public static class Counter implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        for (int index = 0; index < 1000; index++) {
            Thread.sleep(1);
            System.out.println(index);
        }
        return null;
    }
}