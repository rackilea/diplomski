public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, SMSReceiver.class.getSimpleName() +"\naction: " + intent.getAction());
        if(isOnline(context) == true) {
            //do your staff
            context.startActivity(new Intent(context, MainActivity.class));
        }
    }

    boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

}