int counter = loadLastCounterValue();
    for(String s : sList){
            Notification notification = new NotificationCompat.Builder(this).setContentTitle("Title").setContentText(s).setSmallIcon(R.drawable.ic_launcher).setContentIntent(pendingIntent).build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(++counter, notification);
    }
    saveCounter(counter);