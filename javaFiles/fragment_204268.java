public interface IRoutingHandling {

    void writeMessage(Long key, HashSet<String> value);

}

public class Routing implements IRoutingHandling {

    private final Hashtable<Long, HashSet<String>> reverseLookup;

    private ASender asender;
    private BSender bsender;

    public Routing() {
        //Constructor work to be done here.. 
        reverseLookup = new Hashtable<Long, HashSet<String>>();
    }

    public void notify(TopicEvent event) {
        if (event.getMessage() instanceof AMessage) {
            asender = new ASender(this, event.getMessage())

        } else if (event.getMessage() instanceof BMessage) {
            bsender = new BSender(this, event.getMessage())

        }
    }

    @Override
    public void writeMessage(Long key, HashSet<String> value) {
        reverseLookup.put(key, value);
    }

}

public class ASender implements Runnable {

    private IRoutingHandling _routingHandling;

    public ASender(IRoutingHandling r, RoutingMessage rm) {
        _routingHandling = r;
        routingMessage = rm;
        this.run();
    }

    public void run() {
        handleMessage();
    }

    private void handleMessage() {
        // do some stuff and extract data from the routing message object

        _routingHandling.writeMessage(somethingToSetAsKey, somethingToSetAsValue)
    }

}