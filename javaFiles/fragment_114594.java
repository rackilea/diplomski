abstract class Command {
    final public void execute(){
          run();
          onComplete();
    }
    protected abstract void run();
    protected abstract void onComplete();
}
//usage
abstract class HiCommand extends Command {
    protected void run(){
        System.out.println("Hi, ");
    }

    protected abstract void onComplete();
}

new HiCommand(){
    @Override
    protected void onComplete() {
        System.out.println("world");
    }
}.execute();