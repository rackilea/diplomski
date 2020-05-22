public class SomeRunnable implements Runnable {

    private WeakReference<Handler> mHandlerRef;

    public SomeRunnable(Handler handler) throws IOException {
        . . .    
        mHandlerRef = new WeakReference<Handler>( handler );
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                    . . .
                    Handler mHandler = mHandlerRef.get();
                    if( mHandler != null ) {
                        Message msg = mHandler.obtainMessage();
                        . . .
                        mHandler.sendMessage(msg);
                    }
                }

            } catch (IOException e) {
                Log.e("Error", e.hashCode() + ": " + e.getLocalizedMessage());
            }
        }
    }
}