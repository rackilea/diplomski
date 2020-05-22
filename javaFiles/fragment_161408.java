import net.rim.device.api.ui.UiApplication;

public abstract class AsyncTask {

    public static final int FINISHED = 0;
    public static final int PENDING = 1;
    public static final int RUNNING = 2;

    private int _status = PENDING;
    private boolean _cancelled = false;
    private Thread _worker;

    /** subclasses MUST implement this method */
    public abstract Object doInBackground(Object[] params);

    protected void onPreExecute() {
        // default implementation does nothing
    }
    protected void onPostExecute(Object result) {
        // default implementation does nothing
    }
    protected void onProgressUpdate(Object[] values) {
        // default implementation does nothing
    }
    protected void onCancelled() {
        // default implementation does nothing
    }
    protected void onCancelled(Object result) {
        onCancelled();
    }

    public final int getStatus() {
        return _status;
    }

    public final boolean isCancelled() {
        return _cancelled;
    }

    public final boolean cancel(boolean mayInterruptIfRunning) {
        if (_status == FINISHED || _cancelled) {
            return false;
        } else {
            _cancelled = true;
            if (mayInterruptIfRunning && _status == RUNNING) {
                // NOTE: calling Thread.interrupt() usually doesn't work
                //   well, unless you don't care what state the background
                //   processing is left in.  I'm not 100% sure that this is how
                //   Android's AsyncTask implements cancel(true), but I 
                //   normally just cancel background tasks by letting the
                //   doInBackground() method check isCancelled() at multiple
                //   points in its processing.
                _worker.interrupt();
            }
            return true;
        }
    }

    protected final void publishProgress(final Object[] values) {
        // call back onProgressUpdate on the UI thread
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                onProgressUpdate(values);
            }
        });
    }

    private void completeTask(final Object result) {
        // transmit the result back to the UI thread
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                if (isCancelled()) {
                    onCancelled(result);
                } else {
                    onPostExecute(result);
                }
                // TODO: not sure if status should be FINISHED before or after onPostExecute()
                _status = FINISHED;
            }
        }); 
    }

    public AsyncTask execute(final Object[] params) throws IllegalStateException {
        if (getStatus() != PENDING) {
            throw new IllegalStateException("An AsyncTask can only be executed once!");
        } else {
            try {
                onPreExecute();

                _worker = new Thread(new Runnable() {
                    public void run() {
                        try {
                            // run background work on this worker thread
                            final Object result = doInBackground(params);
                            completeTask(result);
                        } catch (Exception e) {
                            // I believe if Thread.interrupt() is called, we'll arrive here
                            completeTask(null);
                        }
                    }
                });
                _status = RUNNING;
                _worker.start();
            } catch (Exception e) {
                // TODO: handle this exception
            }
        }

        return this;
    }

}