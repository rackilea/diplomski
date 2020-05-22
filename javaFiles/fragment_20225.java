NotificationCompat.Builder b = new NotificationCompat.Builder(c);
       b.setNumber(g_push.Counter)
        .setLargeIcon(BitmapFactory.decodeResource(c.getResources(), R.drawable.list_avatar))
        .setSmallIcon(R.drawable.ic_stat_example)
        .setAutoCancel(true)
        .setContentTitle(pushCount > 1 ? c.getString(R.string.stat_messages_title) + pushCount : title)
        .setContentText(pushCount > 1 ? push.ProfileID : mess)
        .setWhen(g_push.Timestamp)
        .setContentIntent(PendingIntent.getActivity(c, 0, it, PendingIntent.FLAG_UPDATE_CURRENT))
        .setDeleteIntent(PendingIntent.getBroadcast(c, 0, new Intent(ACTION_CLEAR_NOTIFICATION), PendingIntent.FLAG_CANCEL_CURRENT))
        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
        .setSound(Uri.parse(prefs.getString(
                SharedPreferencesID.PREFERENCE_ID_PUSH_SOUND_URI,
                "android.resource://ru.mail.mailapp/raw/new_message_bells")));