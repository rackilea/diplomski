public class ChatPerson {
     //your props here :P...
    private final List<MoveListener> listeners = new ArrayList<MoveListener>();

    private void notifyListeners(MoveEvent e){
        for(MoveListener l : listeners){
             l.onMoveEvent(e);
        }
    }
    public void addMoveListener(MoveListener l){
        this.listeners.add(l);
    }
    public void removeMoveListener(MoveListener l){
        this.listeners.remove(l);
    }

    //i would create a move method but you can do this on setX() and setY()
    public void move(int x,int y){
        this.x=x;
        this.y=y;
        this.notifyListeners(new MoveEvent(this,x,y));
    }
    //your other method...
}