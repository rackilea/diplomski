public interface ListenerHolder {
    public void doSomething();
}

public class Listener {
    public Listener(ListenerHolder holder) {
        this.holder = holder;
    }

    public void doListener() {
        this.holder.doSomething();
    }

    private ListenerHolder holder;
}