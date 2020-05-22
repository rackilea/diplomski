edt=(EditText)findViewById(R.id.edt);

    //create Intent

    //Create listener to listen button click
    OnClickListener listener = new OnClickListener() {
        public void onClick(View view) {
            //Prepare Notification Builder

            Intent myIntent = new Intent(MainActivity.this, NotificationActivity.class);
            myIntent.putExtra("msg",edt.getText().toString());
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );

            //Initialize PendingIntent
            pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            //Initialize NotificationManager using Context.NOTIFICATION_SERVICE
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);


            notificationBuilder = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("Notification Demo").
                            setSmallIcon(R.mipmap.ic_launcher).
                            setContentIntent(pendingIntent)
                    .setContentText(edt.getText().toString());
            //add sound
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            notificationBuilder.setSound(uri);
            notificationBuilder .setWhen(System.currentTimeMillis());
            //vibrate
            long[] v = {500,1000};
            notificationBuilder.setVibrate(v);
            notificationManager.notify(1, notificationBuilder.build());
        }
    };
    Button btn = (Button)findViewById(R.id.button);
    btn.setOnClickListener(listener);