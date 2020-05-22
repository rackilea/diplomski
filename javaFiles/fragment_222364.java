public class DownloadTask extends AsyncTask<String, Void, String> {
  private final Context context;

  public DownloadTask(final Context context) {
    this.context = context;
  }

  @Override 
  protected String doInBackground(String... params) {
    //do your request in here so that you don't interrupt the UI thread
    try {
        return downloadContent(params[0]);
    } catch (IOException e) {
        return "Unable to retrieve data. URL may be invalid.";
    }
  }

  @Override
  public void onPostExecute(String result) {
    String[] smsCzesci = result.split(" ");
    Log.d("TAG", smsCzesci[1]);
    sms = smsCzesci[0];
    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.smap_activity);
    Log.d("TAG", "TA" + sms);
    remoteViews.setTextViewText(R.id.sms, sms);
    AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, SmapActivity.class), remoteViews)
  }
}