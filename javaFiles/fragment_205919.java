public class CountDownBarrier {
    //public static final Logger LOG = LogManager.getLogger(CountDownBarrier.class);
    protected int cnt;
    protected int currCnt;
    protected int sleep;

    protected ReentrantLock lock = null;
    //protected Condition cond = null;

    public CountDownBarrier(int cnt, int sleep) {
        this.cnt = cnt;
        this.currCnt = cnt;
        this.sleep = sleep;

        lock = new ReentrantLock();
        //cond = lock.newCondition();
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            if(currCnt <= 0) {
                //LOG.info("Sleep starts ###################################");
                Thread.sleep(sleep);
                currCnt = cnt;
                //LOG.info("Sleep is over ###################################");
            }
            currCnt--;
        } finally {
            lock.unlock();
        }
    }
}