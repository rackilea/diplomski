public class MoveEvent{
    public final ChatPerson source;//i could be more generic but you get the ideea
    public final int currentX;
    public final int currentY;
    public MoveEvent(ChatPerson source, int x,int y){
        this.source = source;
        this.currentX = x;
        this.currentY = y;
    }
    //you can make the fields private and getters ofc :P
}