public class MyFirebaseMessagingService extends FirebaseMessagingService {
private static final String TAG = "REMOTE_MSG";

@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    if (remoteMessage == null)
        return;

    // check if message contains a notification payload.
    if (remoteMessage.getNotification() != null) {
        Log.e(TAG, "Notification body: " + remoteMessage.getNotification().getBody());
        createNotification(remoteMessage.getNotification());
    }

    // check if message contains a data payload
    if (remoteMessage.getData().size() > 0) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message data payload: " + remoteMessage.getData());
    }
}