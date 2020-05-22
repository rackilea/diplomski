public class ContentsChangedEvent<T> extends ApplicationEvent{

    public ContentsChangedEvent(Holder<T> source, T prev, T curr) {
        super(source);
        this.prev = prev;
        this.curr = curr;
    }                                  

}   

//Holder class
public void change() {
        T prev = curr;
        try {
        curr = payloadType.newInstance();
        } catch (Exception e) {
            int g = 8;
        }
        publisher.publishEvent(new ContentsChangedEvent<T>(this, prev, curr));
 }