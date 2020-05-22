public class MyBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(final Context context, Intent intent) {

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();

        String action = intent.getAction();
        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
            String downloadPath = intent.getStringExtra(DownloadManager.COLUMN_URI);
            editor.putString("downloadPath", downloadPath);
            editor.commit();
        }
    }
}