public interface GameStateListener {
    void onChange(GameState changingFrom, GameState changingTo);
}

public class Game {
    private GameState state = WAITING; // or whatever initial value
    private final Collection<GameStateListener> listeners = new ArrayList<>();

    public void registerListener(GameStateListener listener) {
        listeners.add(listener);
    }

    public void changeState(GameState newState) {
        for (GameStateListener listener : listeners) {
            listener.onChange(state, newState);
        }
        this.state = newState;
    }

    ...
}