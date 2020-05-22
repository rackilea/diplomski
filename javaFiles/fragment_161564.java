ArrayList<SystemListener> listeners = new ArrayList<>();

protected void fireEventQueued(){
    SystemEvent e = new SystemEvent(this);

    listeners.forEach(l -> l.eventQueued(e));
}

public void addSystemListener(SystemListener l){
     listeners.add(l);
}

public void add(something){
    //add something
    fireEventQueued();
}