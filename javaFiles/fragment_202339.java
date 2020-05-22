import java.util.*;

interface Event{
    void receive(Receiver receiver);    
}

class KeyEvent implements Event{
    @Override
    public void receive(Receiver receiver){
        receiver.receive(this);
    }   
}

class MouseEvent implements Event {
    @Override
    public void receive(Receiver receiver){
        receiver.receive(this);
    }   
}

interface Receiver {
    void receive(KeyEvent event);
    void receive(MouseEvent event);
}

class ClientRegistry {
    private Set<Receiver> clients = new HashSet<Receiver>();

    public void subscribe(Receiver client) {
        clients.add(client);
    }

    public void unsubscribe(Receiver client) {
        clients.remove(client);
    }

    public void broadcast(Event eventObject) {
        for(Receiver client: clients) {
            eventObject.receive(client);
        }       
    }   
}

public class Screen implements Receiver {

    public void receive(KeyEvent event) {
        //work
        System.out.println("Processing key event");
    }
    public void receive(MouseEvent event) {
        //work
        System.out.println("Processing mouse event");
    }


    public static void main(String[] args){
        ClientRegistry registry = new ClientRegistry();
        registry.subscribe(new Screen());
        registry.broadcast(new MouseEvent());
    }
}