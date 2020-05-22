public class USBConnect extends BroadcastReceiver {

public NotificationManager myNotificationManager;
public static final int NOTIFICATION_ID = 1;

@Override
public void onReceive(Context context, Intent intent) {

    myNotificationManager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);

      CharSequence NotificationTicket = "USB Connected!";
      CharSequence NotificationTitle = "USB Connected!";
      CharSequence NotificationContent = "USB is Connected!";

      Notification notification = new Notification(R.drawable.usbicon, NotificationTicket, 0);
      Intent notificationIntent = new Intent(context, MyClass.class);
      PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
      notification.setLatestEventInfo(context, NotificationTitle, NotificationContent, contentIntent);
      notification.flags |= Notification.FLAG_ONGOING_EVENT;
      myNotificationManager.notify(NOTIFICATION_ID, notification);
      }
}