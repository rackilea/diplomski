import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class AsyncListenerImpl implements AsyncListener {

    /** The ctx. */
    private AsyncContext ctx;

    public AsyncListenerImpl() {
        super();
    }

    public AsyncListenerImpl(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        /** complete() has already been called on the async context, nothing to do */
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        /** timeout has occured in async task... handle it */
        try {
            // redirect to error page or do whatever is needed
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            ctx.complete();
        }
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        /** THIS NEVER GETS CALLED - error has occured in async task... handle it */
        try {
            // redirect to error page or do whatever is needed
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            ctx.complete();
        }
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        /** async context has started, nothing to do */
    }

}