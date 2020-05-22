public class Machine {
    /* The listener */
    private BrokenListener listener;
    private boolean broken = false;

    public Machine(BrokenListener listener) {
        this.listener = listener;
    }

    /* When the state of the machine changes */
    public void setBroken(boolean broken) {
        this.broken = broken;
        if (this.broken) {
            //Here we pass the current Machine to the StateMachine. How the event is handled should not be up to the machine.
            this.listener.onBrokenEvent(this);                
        }
    }
}