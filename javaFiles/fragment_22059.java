public class RobovmLauncher extends IOSApplication.Delegate {

    @Override
    protected IOSApplication createApplication() {
        EmailHandler emailHandler = new RobovmEmailHandler();
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new MyAwesomeGame(emailHandler), config);
    }
}