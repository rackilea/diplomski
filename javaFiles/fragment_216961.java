public class ControlledFlushWriter extends Writer {
    private long enforcedDelay = 150;
    private long lastFlush = 0;
    private Writer delegated;

    public ControlledFlushWriter(Writer writer, long flushDelay) {
        this.delegated = writer:
        this.enforcedDelay = flushDelay;
    }

    /* simple delegation for other abstract methods... */

    public void flush() {
        long now = System.currentTimeMillis();
        if (now < lastFlush + enforcedDelay) {
            try {
                Thread.sleep(lastFlush + enforcedDelay - now);
            } catch (InterruptedException e) {
                // probably prefer to give up flushing 
                // instead of risking a connection reset !
                return;
            }
        }
        lastFlush = System.currentTimeMillis();
        this.delegated.flush();
    }

}