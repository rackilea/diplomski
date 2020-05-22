public class MyFutureTask extends FutureTask<Object> {

    public MyFutureTask(Runnable r) {
        super(r, null);
    }

    @Override
    protected void done() {
        try {
            if (!isCancelled()) get();
        } catch (ExecutionException e) {
            // Exception occurred, deal with it
            System.out.println("Exception: " + e.getCause());
        } catch (InterruptedException e) {
            // Shouldn't happen, we're invoked when computation is finished
            throw new AssertionError(e);
        }
    }
}