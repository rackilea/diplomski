public class NotifService extends IntentService {
    public static final String TAG = "NotificationService";
    public static final String CHANNEL_ID_MAIN = "Main";
    public static final String CHANNEL_ID_SOUND = "Sound";
    public static final int NOTIFICATION_ID = 123;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public NotifService() {
        super(TAG);//Used to name the worker thread, important only for debugging.
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID_MAIN, "Channel Main", NotificationManager.IMPORTANCE_LOW);
        NotificationChannel sound = new NotificationChannel(CHANNEL_ID_SOUND, "Channel Sound", NotificationManager.IMPORTANCE_HIGH);
            sound.enableVibration(true);
            sound.setVibrationPattern(new long[]{0, 300, 0, 400, 0, 500});
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setLegacyStreamType(AudioManager.STREAM_NOTIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION_EVENT)
                    .build();
            sound.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), aa);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
                notificationManager.createNotificationChannel(sound);
            }
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String channelId = intent.getStringExtra(TAG);
        showNotification(channelId);
    }

    private void showNotification(String channelId) {
        boolean inProgress = channelId.equals(CHANNEL_ID_MAIN);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Work")
                .setContentText(inProgress ? "InProgress" : "Finished")
                .setOngoing(inProgress)
                .setVisibility(VISIBILITY_PUBLIC)
                .setAutoCancel(!inProgress);

        if (!inProgress) {
            builder.setCategory(NotificationCompat.CATEGORY_ALARM);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}