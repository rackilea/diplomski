import java.util.ArrayList;
import java.util.List;

public class Event {
    public static class MouseEvent extends Event {}
    public static class KeyboardEvent extends Event {}
    public static class NetworkEvent extends Event {}
    public static class NotAnEvent {}

public static List<Class<?>> getDeclaredEvents() {
        final Class<?>[] candidates = Event.class.getDeclaredClasses();
        final List<Class<?>> declaredEvents = new ArrayList<Class<?>>();
        for (final Class<?> candidate : candidates) {
            if (Event.class.isAssignableFrom(candidate)) {
                declaredEvents.add(candidate);
            }
        }
        return declaredEvents;
    }

    public static void main(final String args[]) {
        final List<Class<?>> events = Event.getDeclaredEvents();
        for (final Class<?> event : events) {
            System.out.println("event class name: '" + event.getName() + "'.");
        }
    }
}