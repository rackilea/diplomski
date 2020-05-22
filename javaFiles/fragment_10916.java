public class Controller {

    // fields and event handler methods...


    public void shutdown() {
        // cleanup code here...
        System.out.println("Stop");
        action();
        // note that typically (i.e. if Platform.isImplicitExit() is true, which is the default)
        // closing the last open window will invoke Platform.exit() anyway
        Platform.exit();
    }
}