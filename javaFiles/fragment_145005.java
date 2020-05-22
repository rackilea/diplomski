OnClickListener okListener = new OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
        Runnable download = new Runnable() {
            public void run() {
                // Create your input streams and such
                boolean downloadComplete = false;
                while(!downloadComplete  && !Thread.currentThread().isInterruped()) {
                    // Do some downloading
                }
                if (!Thread.currentThread().isInterruped()) {
                    // Alert user of success.
                }
            }
        };
        downloadThread = new Thread(download);
        downloadThread.start();
    }
};
OnClickListener cancelListener = new OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        downloadThread.interrupt();
    }
};