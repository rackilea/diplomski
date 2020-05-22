@Scope(ScopeType.CONVERSATION)
@Name("myController")
public class MyController {
    @In(create = true)
    private MyBackgroundWork myBackgroundWork;

    public void importantMethod() {
        // Execution will return immediately and thread will start
        myBackgroundWork.runInBackground();
    }
}