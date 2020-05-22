public class TestExecutor{
    public static void main(String[] args){
        Executor e = Executors.newCachedThreadPool();
        e = new PreconditionCheckerExecutor(e){
            @Override
            protected void checkPrecondition(Runnable command){
                //do some precondition
            }
        };
        e.execute(/*myRunnable1*/);
        e.execute(/*myRunnable2*/);

    }
}
abstract class PreconditionCheckerExecutor implements Executor
{
    private final Executor executor;

    PreconditionCheckerExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable command) {
        checkPrecondition(command);
        executor.execute(command);
    }

    protected abstract void checkPrecondition(Runnable command);
}