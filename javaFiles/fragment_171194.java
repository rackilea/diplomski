public abstract class State<S extends State<S, H>, H extends HasAState<S, H>>{
    protected H parent;

    public void setParent(){ 
        parent.removeState(this);
        this.parent = parent; //!!!this line has no effect!!!
        parent.addState(this);        
    }       
}

public interface HasAState<S extends State<S, H>, H extends HasAState<S, H>> {
    public void addState(State<S, H> state);
    public void removeState(State<S, H> state);
}