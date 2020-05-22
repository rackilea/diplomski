public class ConnectivityStatusReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {

    final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

    if (activeNetworkInfo != null) {
      Toast.makeText(context, activeNetworkInfo.getTypeName() + " connected", Toast.LENGTH_SHORT).show();

      // Your code to start Activity B
      Activity activity = (Activity) context;
      intent = new Intent(activity, ActivityB.class);
      activity.startActivity(intent);

    } else {
      Toast.makeText(context, "No Internet or Network connection available", Toast.LENGTH_LONG).show();
    }
  }

}