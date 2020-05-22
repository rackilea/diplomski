public class MessageBus {

    public enum Action {
        CREATE, REMOVE, UPDATE, DELETE;
    }

    private static Map<Class<?>, Set<Subscriber<?>>> subscriptions;

    static {
        subscriptions = new HashMap<Class<?>, Set<Subscriber<?>>>();
    }

    @SuppressWarnings("unchecked")
    public static <T> void publish(T message, Action action) {
        Set<Subscriber<?>> set = getSubscribersFor(message.getClass());

        if (set == null)
            return;

        for (Subscriber<?> subscriber: set) {
            ((Subscriber<T>) subscriber).onMessage(message, action);
        }
    }

    public static <T> void subscribe(Class<T> type, Subscriber<T> subscriber) {
        Set<Subscriber<?>> set = getSubscribersFor(type);

        if (set == null) {
            set = new HashSet<Subscriber<?>>();
            subscriptions.put(type, set);
        }

        set.add(subscriber);
    }

    public static <T> void unsuscribe(Class<T> type, Subscriber<T> subscriber) {
        Set<Subscriber<?>> set = getSubscribersFor(type);
        set.remove(subscriber);
    }

    private static Set<Subscriber<?>> getSubscribersFor(Class<?> topic) {
        return subscriptions.get(topic);
    }
}