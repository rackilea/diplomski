public enum EventType {

    HUNGRY,
    PEE;
}

public interface DogEvent {

    EventType getType();
}

public interface DogListener {

    void fireEvent(DogEvent event);
}

public class Dog {

    private final Set<DogListener> listeners = new CopyOnWriteArraySet<DogListener>();

    public void register(final DogListener dogListener) {
        listeners.add(dogListener);
    }

    public void unregister(final DogListener dogListener) {
        listeners.remove(dogListener);
    }

    public void firePeeEvent() {
        fireEvent(new DogEvent() {
            @Override
            public EventType getType() {
                return EventType.PEE;
            }
        });
    }

    public void fireHungryEvent() {
        fireEvent(new DogEvent() {
            @Override
            public EventType getType() {
                return EventType.HUNGRY;
            }
        });
    }

    private void fireEvent(final DogEvent dogEvent) {
        for (final DogListener listener : listeners) {
            listener.fireEvent(dogEvent);
        }
    }
}

public class Owner implements DogListener {

    @Override
    public void fireEvent(DogEvent event) {
        switch (event.getType()) {
            case PEE:
                System.out.println("Someone take the dog out");
                break;
            case HUNGRY:
                System.out.println("I can't believe the dog is hungry _again_!");
                break;
        }
    }
}