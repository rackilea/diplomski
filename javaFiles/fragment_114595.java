interface WhenDone{
    void onComplete();
}

abstract class Command {
    private final WhenDone callback;
    protected Command(WhenDone callback){
        this.callback = callback;
    }
    final public void execute(){
          run();
          callback.onComplete();
    }
    protected abstract void run();
}
//usage
class PrintHi extends Command {
    protected PrintHi(WhenDone callback){
        super(callback);
    }

    protected void run(){
        System.out.println("Hi, ");
    }
}

class PrintWorld implements WhenDone {
    public void onComplete(){
        System.out.println("world!");
    }
}
//somewhere
new PrintHi(new PrintWorld()).execute();