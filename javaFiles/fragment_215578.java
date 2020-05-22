public class JobRunner implements Runner {

    private final Striped<Lock> locks;
    private final int typeId;

    public JobRunner(Striped<Lock> locks, int typeId){
        this.locks = locks;
        this.typeId = typeId;
    }

    public void run() {
        lock = locks.get(typeId);
        lock.lock() //This blocks the thread untill the lock becomes available if it wasn't already
        doWork()
    }

    private void doWork(){
        //Bus, do your stuff!
    }

}