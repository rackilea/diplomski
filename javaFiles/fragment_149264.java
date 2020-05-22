public class ArlabFacade {

    private static ArlabFacade mArlabFacade = null;

    /* Create a synchronised singleton instance */
    private static final ReentrantLock lock = new ReentrantLock();

    private ArlabFacade(Context context) {     
        /* initialize properties */
        mContext = context;
    }

    public static ArlabFacade getInstance(Context context) {
        lock.lock();
        if(mArlabFacade == null) {
            mArlabFacade = new ArlabFacade(context);
        }
        lock.unlock();
        return mArlabFacade;
    }

    public NotAPOI createNewPOI() {
        return new NotAPOIImpl(new POI());
    }

    private static class NotAPOIImpl implements NotAPOI {
        private POI poi;
        private NotAPOIImpl(POI poi) {
            this.poi = poi;
        }
        public void doSomething() {
            poi.doSomething();
        }
    }
}

// As you don't like to expose the POI just hide it behind the interface
public interface NotAPOI {
    void doSomething();
}