public class Application implements IApplication {

    public Object start(IApplicationContext context) throws Exception {
        System.out.println("Hello world!");
        return IApplication.EXIT_OK;
    }

    public void stop() {
        System.out.println("By by!");
    }
}