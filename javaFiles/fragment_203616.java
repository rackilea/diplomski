public class Notifier {
    private static Notifier instance = null;

    @SuppressWarnings("rawtypes")
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public Notifier() {};

    public <T> void  subscribe(String topic, Notifiable<T> n) {
        if (!this.hasSubscriber(topic, n)) {
            this.subscribers.add(new Subscriber<T>(topic, n));
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void publish(String topic, T data) {
        for (Subscriber<T> s : this.subscribers) {
            if (s.topic.equals(topic)) {
                s.notifiable.onEvent(data);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Boolean hasSubscriber (String topic, Notifiable<T> n) {
        for (Subscriber<T> s : this.subscribers) {
           /* XXX: Beware, is safe to compare two notifiable
            * instances by their memory addresses??
            */
           if (s.topic.equals(topic) && s.notifiable == n) {
                return true;
           }
        }
        return false;
    }

    public static Notifier getInstance() {
        if (instance == null) {
            instance = new Notifier();
        }
        return instance;
    }
}