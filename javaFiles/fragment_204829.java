public class MyTask implements Task {
    private String result;
    public synchronized void onComplete() {
        result = "it worked";
        // this is allowed because the method is synchronized
        notify();
    }
    public synchronized void onFail() {
        result = "it failed";
        // this is allowed because the method is synchronized
        notify();
    }
    public synchronized String waitForResult() {
        // a while loop is a good pattern because of spurious wakeups
        // also, it's important to realize that the job might have already
        // finished so we should always test it _before_ we wait
        while (result == null) {
            wait();
        }
        return result;
    }
}