public class PendingService extends Service {

    private final static String TAG = "PendingService";
    public final static int NOTIFICATION_ID = 94;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startInForeground();

        // Do your work here ...

        return START_STICKY;
    }

    private void startInForeground() {
        String NOTIFICATION_CHANNEL_ID = "default";
        String NOTIFICATION_CHANNEL_NAME = "My Pending Service";
        String NOTIFICATION_CHANNEL_DESC = "This notification holding a pending task";

        Intent notificationIntent = new Intent(this, SplashActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.notification)
                .setOngoing(true)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            channel.setDescription(NOTIFICATION_CHANNEL_DESC);
            channel.setSound(null, null);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        Notification notification = builder.build();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeNotification(NOTIFICATION_ID);
        // ....
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void removeNotification(int notificationId) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.cancel(notificationId);
        }
    }
}