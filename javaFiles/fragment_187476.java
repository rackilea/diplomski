private static class PromotionBarrier {
    private final AtomicBoolean hasAccess = new AtomicBoolean(false);
    private final AtomicLong counter = new AtomicLong(0);
    private final long maxCustomers = 3;
    public boolean hasAccess() {
        if(hasAccess.get()) {
            long value = counter.incrementAndGet();
            if(value <= maxCustomers) {
                return true;
            } else {
                hasAccess.set(false);
                return false;
            }
        }
        return false; 
    }
}

private static class PromotionRunnable implements Runnable {
    private final PromotionBarrier promotionBarrier;

    public PromotionRunnable(final PromotionBarrier promotionBarrier) {
        this.promotionBarrier = barrier;
    }

    @Override
    public void run() {
        if(promotionBarrier.hasAccess()) {
            // Yoohoo I got it!
        } else {
            // Rha I am too late!!
        }
    }