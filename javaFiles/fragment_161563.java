public class SystemEvent extends java.util.EventObject{
    public SystemEvent(SystemQueue src){
        super(src);
    }

    public SystemQueue getSource(){
         return (SystemQueue) super.getSource();
    }
}