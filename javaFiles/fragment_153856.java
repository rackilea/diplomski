class PollingRunnable implements Runnable{

    private static final String TAG = PollingRunnable.class.getSimpleName();

    private InputStream inputStream;
    private volatile boolean shouldKeepPolling = true;

    public PollingRunnable(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public void stopPolling() {
        shouldKeepPolling = false;
    }

    @Override
    public void run() {
        while (shouldKeepPolling) {
            final byte[] buffer = new byte[256];
            int bytesRead = 0;
            try {
                bytesRead = inputStream.read(buffer, 0, buffer.length);
                String fullResponse = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                //Process response
            } catch (IOException e) {
                Log.e(TAG, "Exception while polling input stream! ", e);
            } finally {
                if(inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e1) {
                        Log.e(TAG, "Exception while closing input stream! ", e1);
                    }
                }
            }
        }
    }
}