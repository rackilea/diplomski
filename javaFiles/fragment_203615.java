public class Subscriber<T> {
    public String topic;
    public Notifiable<T> notifiable;
    public Subscriber(String topic, Notifiable<T> n) {
        ...
    }
 }