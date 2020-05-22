public class UThreadApp {
    protected void UThreadApp(String[] args) {
        newUThread("umain", args);
            ...
    }
    native void newUThread(String method, String[] args);
}

public class App extends UThreadApp {
    public void main(String[] args) {
        new App(args);
    }
    public App(String[] args) {
        super(args);
    }
}