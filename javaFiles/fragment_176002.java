public class NextMove {
    private volatile int mCardIndex;
    private final CountDownLatch mMoveReady = new CountDownLatch(1);

    public int getMove() throws InterruptedException {
        mMoveReady.await();
        return mCardIndex;
    }

    public synchronized void setMove(int selectedCardIndex) {
        if (mMoveReady.getCount() > 0) {
            mCardIndex = selectedCardIndex;
            mMoveReady.countDown();
        }
    }
}