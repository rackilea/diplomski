public class MyRunnableClass implements Runnable {
    private Listener mListener;

    interface Listener {
        void onError(Throwable error);
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    @Override
    public void run() {
        // Some important code to be executed goes here

        // Pretend an exception was caught in a try/catch/finally
        // block that was doing an I/O operation

        Throwable someError = new IOException();

        if (mListener != null) {
            mListener.onError(someError);
        }
    }
}