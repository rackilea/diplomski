public Notification buildNotification()
   {
      Intent intent = new Intent(mContext, MainActivity.class);
      PendingIntent pIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

      setContentView();

      Notification.Builder notibuilder = new Notification.Builder(mContext);
         notibuilder.setContentTitle(" ");
         notibuilder.setContentText(" ");
         notibuilder.setSmallIcon(R.drawable.ic_launcher);
         notibuilder.setOngoing(true);
         notibuilder.setAutoCancel(false);
         notibuilder.setContentIntent(pIntent);
         notibuilder.setContent(mContentView);
         notibuilder.setTicker(null);


         mNotification = notibuilder.build();

      NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

      return mNotification;
   }

   public void setContentView()
   {
      mContentView = new RemoteViews(mContext.getPackageName(), R.layout.custom_notification);
      mContentView.setTextViewText(R.id.notificaiton_app_title, "");

      String currentChannel = "  ";
      if ( mCurrentChannel != -1)
         currentChannel = " " + (mCurrentChannel + 1);
      mContentView.setTextViewText(R.id.notificaiton_app_channel, currentChannel);

      Intent previousIntent = new Intent(mContext, NotificationButtonIntentService.class);
      previousIntent.setAction(NotificationButtonIntentService.Action_Previous);
      mContentView.setOnClickPendingIntent(R.id.notification_layout_previous, PendingIntent.getService(mContext, 0, previousIntent,  PendingIntent.FLAG_CANCEL_CURRENT));
      mContentView.setOnClickPendingIntent(R.id.notification_image_previous, PendingIntent.getService(mContext, 0, previousIntent,  PendingIntent.FLAG_CANCEL_CURRENT));

      Intent playIntent = new Intent(mContext, NotificationButtonIntentService.class);

      if ( mCurrentChannel != -1)
      {
         playIntent.setAction(NotificationButtonIntentService.Action_Pause);
         mContentView.setInt(R.id.notification_image_play_pause, "setBackgroundResource", R.drawable.ic_media_pause);
      }
      else
      {
         playIntent.setAction(NotificationButtonIntentService.Action_Play);
         mContentView.setInt(R.id.notification_image_play_pause, "setBackgroundResource", R.drawable.ic_media_play);
      }

      mContentView.setOnClickPendingIntent(R.id.notification_layout_play_pause, PendingIntent.getService(mContext, 0, playIntent, PendingIntent.FLAG_CANCEL_CURRENT));
      mContentView.setOnClickPendingIntent(R.id.notification_image_play_pause, PendingIntent.getService(mContext, 0, playIntent, PendingIntent.FLAG_CANCEL_CURRENT));

      Intent nextIntent = new Intent(mContext, NotificationButtonIntentService.class);
      nextIntent.setAction(NotificationButtonIntentService.Action_Next);
      mContentView.setOnClickPendingIntent(R.id.notification_layout_next, PendingIntent.getService(mContext, 0, nextIntent, PendingIntent.FLAG_CANCEL_CURRENT));
      mContentView.setOnClickPendingIntent(R.id.notification_image_next, PendingIntent.getService(mContext, 0, nextIntent, PendingIntent.FLAG_CANCEL_CURRENT));

      Intent closeIntent = new Intent(mContext, NotificationButtonIntentService.class);
      closeIntent.setAction(NotificationButtonIntentService.Action_Close);
      mContentView.setOnClickPendingIntent(R.id.notification_layout_close, PendingIntent.getService(mContext, 0, closeIntent, PendingIntent.FLAG_CANCEL_CURRENT));
      mContentView.setOnClickPendingIntent(R.id.notification_image_close, PendingIntent.getService(mContext, 0, closeIntent, PendingIntent.FLAG_CANCEL_CURRENT));
   }