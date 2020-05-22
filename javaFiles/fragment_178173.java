// improve class name and have it implement Runnable    
public class AProducerTask implements Runnable {
    private aMessageBuffer msgbuf = new aMessageBuffer();

    @Override // don't forget this!
    public void run() {
        msgbuf.sendMsg("add",3);
    }
}