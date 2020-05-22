public class USBDisCon extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE); 
    notificationManager.cancel(USBConnect.NOTIFICATION_ID);
    }
}