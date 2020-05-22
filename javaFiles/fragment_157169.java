public class LocationService extends Service implements CallbackResponseListener, LocationListener {

public void onCreate() {
            super.onCreate();
        }
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            super.onStartCommand(intent, flags, startId);
            Log.e("Service Started", "onStartCommand!");
            createNotificationChannel();
            startTimer();
            return START_STICKY;
        }
     private void createNotificationChannel() {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Service channel";
                String description = "Service channel description";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("12", name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
            Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);

            PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 0,
                    notificationIntent, 0);
            Notification notification = new NotificationCompat.Builder(this, "12")
                    .setContentTitle("Title")
                    .setContentText("App is running in background for location")
                    .setSmallIcon(R.drawable.notification_icon).setContentIntent(intent)
                    .build();
            startForeground(2001, notification);
        }
        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.e("Service EXIT", "ondestroy!");    
                Intent broadcastIntent = new Intent(getApplicationContext(), LocationBroadcastReceiver.class);
                sendBroadcast(broadcastIntent);

            stoptimertask();
        }


        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
     public void startTimer() {
            //set a new Timer
            try {
                timer = new Timer();   
                //initialize the TimerTask's job
                initializeTimerTask(); 
                //schedule the timer, to wake up every 1 second
                timer.schedule(timerTask, AppConstants.bgTaskStartDelay,2000); //
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                try {
                    // add your code here for schedule




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}