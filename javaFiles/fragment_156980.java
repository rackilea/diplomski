public class WebAdaptor {

    public WebAdaptor(Subscriber subscriber) { /* Added a new constructor */
       this.subscriber = subscriber;
    }

    private Subscriber subscriber;

    public void run() {
        subscriber.init();
    }
}