import javax.servlet.AsyncContext;

public class AsyncServletTaskRunner implements Runnable {

    /** The ctx. */
    private AsyncContext ctx;

    /** The processor. */
    private AsyncServletTaskProcessor processor;

    public AsyncServletTaskRunner() {
        super();
    }

    public AsyncServletTaskRunner(AsyncContext ctx, AsyncServletTaskProcessor processor) {
        this.ctx = ctx;
        this.processor = processor;
    }

    @Override
    public void run() {

        try {
            processor.process(ctx);
        } catch (Exception e) {
            try {
                // redirect to error page or do whatever is needed
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            ctx.complete();
        }
    }

    public AsyncContext getCtx() {
        return ctx;
    }

    public void setCtx(AsyncContext ctx) {
        this.ctx = ctx;
    }

}