task = new TimerTask() {
    @Override
    public void run() {
        int fileSize=(int)fileSizeToReceive;
        int actual= totalReceived;

        ((Notification.Builder) mBuilderReceive)
            .setContentText("Receiving  "+actualNameToReceive);
        ((Notification.Builder) mBuilderReceiver)
            .setProgress(fileSize, actual, false);
        mNotifyManager.notify(id, ((Notification.Builder) mBuilderReceive)
            .getNotification());
    }
};

receiveTimer.scheduleAtFixedRate(task, 0, 500);