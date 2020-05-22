public class CachingThreadFactory implements ThreadFactory{
    // amount of active threads at max
    private static final int THREAD_POOL_MAX_SIZE = 8;

    // interval in milliseconds of the clean up task
    private static final int CLEAN_UP_INTERVAL = 2000;

    // the actual cache
    private final Thread[] cachedThreads = new Thread[THREAD_POOL_MAX_SIZE];

    // clean up task definition
    {
        new Timer().scheduleAtFixedRate(new CleanUpTask(), 0, CLEAN_UP_INTERVAL);
    }

    @Override
    public synchronized Thread newThread(Runnable r){
        for(int i = 0; i < cachedThreads.length; i++){
            if(cachedThreads[i] == null){
                return cachedThreads[i] = new Thread(r, "T" + i);
            }
        }
        return null;
    }

    private final class CleanUpTask extends TimerTask{
        @Override
        public void run(){
            synchronized(CachingThreadFactory.this){
                for(int i = 0; i < cachedThreads.length; i++){
                    final Thread thread = cachedThreads[i];
                    if(thread != null && !thread.isAlive()){
                        cachedThreads[i] = null; // unset
                    }
                }
            }
        }
    }
}