public class SomeContext {

    private static ThreadLocal<SomeContext> instance = new ThreadLocal<SomeContext>();
    private User user;

    private SomeContext(User user) {
        this.user = user;
    }

    public static SomeContext getCurrentInstance() {
        return instance.get();
    }

    public static SomeContext newInstance(User user) {
        SomeContext someContext = new SomeContext(user);
        instance.set(someContext);
        return someContext;
    }

    public void release() {
        instance.remove();
    }

    public User getUser() {
        return user;
    }

}