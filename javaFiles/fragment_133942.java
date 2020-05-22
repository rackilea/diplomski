import java.util.concurrent.LinkedBlockingDeque;
import static java.lang.System.*;
class Message{
    String message;
    public Message(String message) {this.message=message;}
    public String toString(){return message;}
}
public class Test {
static LinkedBlockingDeque<Message> outgoing=new LinkedBlockingDeque<>();
    public static void main(String[] args) {
        for(int i=0;i<10;i++) new Player(outgoing,i).start();
        for(int i=0;i<3;i++)  new Sender(outgoing,i).start();
    }
}
class Player extends Thread{
    private LinkedBlockingDeque<Message> outgoing;
    private int id;
    public Player(LinkedBlockingDeque<Message> outgoing,int id){this.outgoing=outgoing; this.id=id;}
    public void run(){
        for(int i=0;i<10;i++){
            try {
                outgoing.putLast(new Message(String.format("Player %d's message",id)));
                Thread.sleep(20);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
class Sender extends Thread{
    private LinkedBlockingDeque<Message> outgoing;
    private int id;
    public Sender(LinkedBlockingDeque<Message> outgoing,int id){this.outgoing=outgoing; this.id=id;}
    public void run(){
        while(true){
            Message m = null;
            try {
                m = outgoing.takeFirst();
                //send message
                if(Math.random()>0.95){
                    out.printf("Sender %d is hanging! %n",id);
                    Thread.sleep(1000);//Slow socket is blocking!
                }
            } catch (InterruptedException e) {e.printStackTrace();}
            out.printf("Sender %d sent message \"%s\" %n",id,m);
        }
    }
}