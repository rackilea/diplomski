public class CommandDemoEx{
    public static void main(String args[]){

        // On command for TV with same invoker 
        Receiver r = new TV();
        Command onCommand = new OnCommand(r);
        Invoker invoker = new Invoker(onCommand);
        invoker.execute();

        // On command for DVDPlayer with same invoker 
        r = new DVDPlayer();
        onCommand = new OnCommand(r);
        invoker = new Invoker(onCommand);
        invoker.execute();

    }
}
interface Command {
    public void execute();
}

class Receiver {
    public void switchOn(){
        System.out.println("Switch on from:"+this.getClass().getSimpleName());
    }
}

class OnCommand implements Command{

    private Receiver receiver;

    public OnCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public void execute(){
        receiver.switchOn();
    }
}

class Invoker {
    public Command command;

    public Invoker(Command c){
        this.command=c;
    }
    public void execute(){
        this.command.execute();
    }
}

class TV extends Receiver{
    public TV(){

    }
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
class DVDPlayer extends Receiver{
    public DVDPlayer(){

    }
    public String toString(){
        return this.getClass().getSimpleName();
    }
}