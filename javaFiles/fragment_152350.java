Button button=(Button)findViewById(R.id.button);
button.setOnClickListener(new OnclickListener(){
    @Override
    public void onClick(View v){

      NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      Notification notification = new    Notification(R.drawable.image,"Notification",System.currentTimeMillis());
     Intent notificationIntent = new Intent(Currentclass.this,TargetActivity.class);
     PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
     notification.setLatestEventInfo(getApplicationContext(), "Title", "Sub Title",contentIntent);
     notification.flags=Notification.FLAG_AUTO_CANCEL;
     mNotificationManager.notify(143, notification);

  }

});