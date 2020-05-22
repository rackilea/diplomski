// locking code removed
void turnOn() {
    DirectionState directionState = ref.get();
    directionState.compareAndSet(directionState, new DirectionState(directionState.getDirection(), State.ON));
}
// similar for pointLeft()