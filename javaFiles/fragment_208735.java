public class MyComponent {
    private int data;
    // getters / setters
}

public class MyTimerTask extends TimerTask {
    private final MyComponent myComponent;
    public MyTimerTask(MyComponent myComponent) {
        super();
        this.myComponent = myComponent;
    }
    @Override
    public void run() {
        // here you can access your component's data value
        int val = this.myComponent.getData();
        // do whatever you need to
    }
}