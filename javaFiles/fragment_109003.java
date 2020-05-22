public class Task implements Runnable {
    private YourObject yourObject;

    public Task(YourObject yourObject) {
        this.yourObject = yourObject;
    }

    @Override
    public void run() {
        yourObject.setSomething("something"); // See?
    }
}