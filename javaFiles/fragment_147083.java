public class ScrumBoard {

    // list of listeners    
    private static List<SwitchChangeListener> LISTENERS = new ArrayList<>();
    // initial state
    private static SwitchState STATE = SwitchState.OFF;

    // state change listener contract
    public interface SwitchChangeListener {
        void handleStateChange(SwitchState state);
    }

    // handle a a state change request
    public static synchronized void updateState(boolean value) {
        STATE = SwitchState.from(value);
        fireChangeEvent(STATE);
    }

    // register a new state listener
    public static synchronized void addSwitchChangeListener(SwitchChangeListener listener) {
        System.out.println("Added listener for " + listener);
        LISTENERS.add(listener);
        // when a new listener is registered, also inform it of the current state
        listener.handleStateChange(STATE);
    }

    // remove a state listener
    public static synchronized void removeSwitchListener(SwitchChangeListener listener) {
        LISTENERS.remove(listener);
    }

    // fire a change event to all registered listeners
    private static void fireChangeEvent(SwitchState state) {
        for (SwitchChangeListener listener : LISTENERS) {
            listener.handleStateChange(state);
        }
    }
}