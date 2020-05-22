public abstract class TaskManager<A, B, C> {

    public abstract A init();

    public abstract B start();

    public abstract C shutDown();

    public abstract void analyzeAfterInit(A initResult);

    public abstract void analyzeAfterStart(B startResult);

    public final booelan  runManager(){

       A initResult = init();
       analyzeAfterInit(initResult);
       B startResult = start();
       analyzeAfterStart(startResult);
       shutDown();

    }
}