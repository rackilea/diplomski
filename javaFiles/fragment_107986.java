public class DirectionState {
    private final Direction direction;
    private final State state;
    // rest of class omitted
}


private AtomicReference<DirectionState> ref = new AtomicReference<>(new DirectionState(Direction.LEFT, State.OFF));