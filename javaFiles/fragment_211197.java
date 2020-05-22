public class MyWorker extends Worker {

    public MyWorker() {
        super(new MyOtherWorker());
    }

    public abstract void preProcess(Workpiece wp) {
        // code
    }

    public abstract void postProcess(Workpiece wp) {
        // code
    }
}