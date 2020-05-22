public class HelloWorldApplication extends WebApplication {
    @Override
    protected void init() {
        mountPage("/helloworld", HelloWorld.class);
        mountPage("/helloworld2", HelloWorld2.class);
    }

    @Override
    public Class getHomePage() {
        return HelloWorld.class;
    }
}