public void onReceive(final Context context, Intent intent) {

    // We can't wait on the main thread as it would be blocked if we wait for too long
    new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                // Lets wait for 10 seconds
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }

            // Start your application here
        }
    }).start();
}