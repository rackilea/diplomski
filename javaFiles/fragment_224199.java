@ManagedBean
@RequestScoped
public class Register {

    @ManagedProperty("#{taskManager}")
    private TaskManager taskManager;

    public void submit() {
        // ...

        taskManager.submit(new MailTask(mail));
        // You might want to hold the return value in some Future<Result>, but
        // you should store it in view or session scope in order to get result
        // later. Note that the thread will block whenever you call get() on it.
        // You can just ignore it altogether (as the current example is doing).
    }

}