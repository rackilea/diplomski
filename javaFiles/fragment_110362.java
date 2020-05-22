@Override
public void onReceive(Context context, Intent intent) { 
  if (intent.getStringExtra("Error") != null) { 
    String callingActivity = intent.getStringExtra ("CallingActivity");
    if (callingActivity != null);
    context.getSharedPreferences (callingActivity, Context.MODE_PRIVATE).edit().putString ("errorMessage", "You have an error").commit();
  }
}