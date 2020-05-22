public static class YourBroadcastReceiver extends BroadcastReceiver{

    // Constructor is mandatory
    public MediaBroadcastReceiver ()
    {
        super ();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Log.i (TAG_MEDIA, intentAction.toString() + " happended");
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            Log.i (TAG_MEDIA, "no media button information");
            return;
        }
        KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            Log.i (TAG_MEDIA, "no keypress");
            return;
        }
        // other stuff you want to do
    }
}