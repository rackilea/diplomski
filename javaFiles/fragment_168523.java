public class NotifyHandlerReceiver extends BroadcastReceiver {

    public static final String ACTION = "me.pepyakin.defferednotify.action.NOTIFY";

    public void onReceive(Context context, Intent intent) {
        if (ACTION.equals(intent.getAction())) {
             Notification.Builder builder = new Notification.Builder(context)
                .setTicker("Notifica")
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentTitle("Notifica")
                .setContentText("Hai una notifica!")
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), 0));

            NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify("interstitial_tag", 1, builder.build());
       }
    }
}