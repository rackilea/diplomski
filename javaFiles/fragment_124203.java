@Test
public void jobs() {

    Callable<Boolean> callable = new Callable<Boolean>() {
    @Override
    public Boolean call() throws Exception {
        System.out.println("Executing Callable.");

        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                System.out.println("UI thread.");
            }
        });

        System.out.println("End.");
        return true;
    }
};

ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(callable);

long stopTimestampt = System.currentTimeMillis() + 1000;
 while (System.currentTimeMillis() < stopTimestampt) {
        Display.getDefault().readAndDispatch();
 }
}