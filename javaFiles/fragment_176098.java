class State {
    private int value;
    public synchronized void mutate(){ value++; }
}
class Z {
    private final State state;
    public Z(State state){
        this.state = state;
    }
    public void oneAtATime(){
        state.mutate();
    }
}
// Usage:
State s1 = new State(), s2 = new State();
Z foo = new Z(s1);
Z bar = new Z(s1);
Z frob = new Z(s2);
Z quux = new Z(s2);