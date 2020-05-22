@Name("myBackgroundWork")
public class MyBackgroundWork {
    @In private transient Dependency1 d1;

    @Asynchronous
    public void runInBackground() {
         d1.doExpensiveStuff();
    }
}