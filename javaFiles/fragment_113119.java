import java.util.HashMap;
import java.util.Map;

public class TestGenerics {

    private Map<Class<?>, EventHandler<?>> handlers = new HashMap<Class<?>, TestGenerics.EventHandler<?>>();

    public interface EventHandler<T> {

        boolean handleEvent(T message);
    }

    // Here you force the invoker to provide the correct type of event handler
    // with the given type of klass
    // If he wants to make this fail, then he will have to use rawtype
    public <T> void registerHandler(Class<T> klass, EventHandler<T> handler) {
        handlers.put(klass, handler);
    }

    public <T> void handle(T message) {
        @SuppressWarnings("unchecked") // Here you can add this annotation since you are forcing any invoker to provide a correct EventHandler
        EventHandler<T> handler = (EventHandler<T>) handlers.get(message.getClass());
        if (handler != null) {
            handler.handleEvent(message);
        }
    }

    public static void main(String[] args) {
        TestGenerics test = new TestGenerics();
        test.registerHandler(Long.class, new EventHandler<Long>() {
            @Override
            public boolean handleEvent(Long message) {
                System.out.println("Received a long " + message);
                return true;
            }
        });
        // Here I use raw type but this also means that I created a weak spot in
        // terms of type safety
        EventHandler handler2 = new EventHandler<String>() {
            @Override
            public boolean handleEvent(String message) {
                System.out.println("THis will never print " + message);
                return false;
            }
        };
        test.registerHandler(Integer.class, handler2); // This is where the
                                                        // problem comes from
        test.handle(3L); // OK
        test.handle(1); // ClassCastException

    }

}