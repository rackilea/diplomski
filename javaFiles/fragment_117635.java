@Scope(ScopeType.CONVERSATION)
@Name("myController")
public class MyController {

    @In(create = true)
    private transient Dependency1 d1;

    public void importantMethod() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LifeCycle.beginCall(); // Start the Seam lifecycle
                Dependency1 d1 = (Dependency1) Component.getInstance("dependency1");
                d1.doExpensiveStuff();
                LifeCycle.endCall();   // Dispose the lifecycle
            }
        }).start();
    }
}