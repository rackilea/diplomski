private final Object lock = new Object();
//...
public void run(){
    boolean inState = false;
    synchronized(lock){
        inState = inState();
        if(inState){ setInState(false);}
    }
}
boolean inState(){
        return this.stateInfo.in_state;
}
void setInState(boolean value){
    this.stateInfo.in_state=value;
}