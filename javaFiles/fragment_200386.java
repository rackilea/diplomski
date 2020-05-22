public interface Subscriber {
    public void notify();
}

public class Publisher {
    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void doWork() {
        System.sleep(100);
            notifyAll();
    }

    private void notifyAll() {
        for(Subscriber s : subscribers) {
            s.notify();
        }
    }
}