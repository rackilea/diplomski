public class StateMachine implements BrokenListener {
    @Override
    public void onBrokenEvent(Object machine) {
        if (machine instanceof Machine) {
            second.add((Machine) machine);
        }
    }
}