public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
private static final String TAG = "FCM_ID";

@Override
public void onTokenRefresh() {
    // get hold of the registration token
    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    // lg the token
    Log.d(TAG, "Refreshed token: " + refreshedToken);
    sendRegistrationToServer(refreshedToken);
}
private void sendRegistrationToServer(String token) {
    // implement this method if you want to store the token on your server
}
}